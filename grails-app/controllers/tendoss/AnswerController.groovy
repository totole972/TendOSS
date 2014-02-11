package tendoss



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnswerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService


    @Transactional
    def save(Answer answerInstance) {
        if (answerInstance == null || !params.tender) {
            notFound()
            return
        }
        def tender = Tender.get(params.tender.toLong())
        answerInstance.author = springSecurityService.currentUser as User
        answerInstance.validate()
        if (answerInstance.hasErrors()) {
            respond answerInstance.errors, view: 'create'
            return
        }

        answerInstance.save flush: true
        tender.addToAnswers(answerInstance)
        tender.save(flush: true)

        redirect(controller: "tender", action: "show" , params : [id: tender.id])
    }

    def edit() {
        def hasError = false
        def redirection = [controller: "tender", action: "show" , params : [id: params?.tenderId?.toLong()]]
        flash.error = []
        if(!params.answerId){
            flash.error << "Aucune réponse passée en paramètre"
           hasError = true
        }
        if(!hasError){
            if(!params.tenderId){
                hasError = true
                flash.error << "Aucun tender passé en paramètre"
            }
            else{
                if(!params.content || params.content == null || params.content =="" ){
                    hasError =true
                    flash.error << "Le contenu de la réponse ne peut être vide"
                }else{
                    def currentUser = springSecurityService.currentUser as User
                    def answer = Answer.get(params.long("answerId"))
                    if(currentUser.id != answer.author.id){
                        hasError = true
                        flash.error << "Vous n'êtes pas l'auteur de cette réponse"
                    }else{
                        answer.content = params.content
                        answer.save(flush: true)
                    }
                }
            }
        }
        if(hasError){
            redirection = [controller: "tender", action: "index"]
        }
        redirect redirection
        return
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'answerInstance.label', default: 'Answer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
