package tendoss

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class TenderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
       params.sort = "submissionDate"
	   params.order = "desc"
 		
 		def query = Tender.where {
 			closed == false
 		}
 		
        respond query.list(params), model:[tenderInstanceCount: Tender.count()]
    }

    def show(Tender tenderInstance) {
        respond tenderInstance
    }

    def create() {
        respond new Tender(params)
    }

    @Transactional
    def save(Tender tenderInstance) {
        if (tenderInstance == null) {
            notFound()
            return
        }

        if (tenderInstance.hasErrors()) {
            respond tenderInstance.errors, view:'create'
            return
        }

        tenderInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tenderInstance.label', default: 'Tender'), tenderInstance.id])
                redirect tenderInstance
            }
            '*' { respond tenderInstance, [status: CREATED] }
        }
    }

    def edit(Tender tenderInstance) {
        respond tenderInstance
    }

    @Transactional
    def update(Tender tenderInstance) {
        if (tenderInstance == null) {
            notFound()
            return
        }

        if (tenderInstance.hasErrors()) {
            respond tenderInstance.errors, view:'edit'
            return
        }

        tenderInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Tender.label', default: 'Tender'), tenderInstance.id])
                redirect tenderInstance
            }
            '*'{ respond tenderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Tender tenderInstance) {

        if (tenderInstance == null) {
            notFound()
            return
        }

        tenderInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Tender.label', default: 'Tender'), tenderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tenderInstance.label', default: 'Tender'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
