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

    def edit(Answer answerInstance) {
        respond answerInstance
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
