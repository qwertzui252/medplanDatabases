package medplandatabases

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MedplandbController {

    MedplandbService medplandbService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond medplandbService.list(params), model:[medplandbCount: medplandbService.count()]
    }

    def show(Long id) {
        respond medplandbService.get(id)
    }

    def create() {
        respond new Medplandb(params)
    }

    def save(Medplandb medplandb) {
        if (medplandb == null) {
            notFound()
            return
        }

        try {
            medplandbService.save(medplandb)
        } catch (ValidationException e) {
            respond medplandb.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medplandb.label', default: 'Medplandb'), medplandb.id])
                redirect medplandb
            }
            '*' { respond medplandb, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond medplandbService.get(id)
    }

    def update(Medplandb medplandb) {
        if (medplandb == null) {
            notFound()
            return
        }

        try {
            medplandbService.save(medplandb)
        } catch (ValidationException e) {
            respond medplandb.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medplandb.label', default: 'Medplandb'), medplandb.id])
                redirect medplandb
            }
            '*'{ respond medplandb, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        medplandbService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medplandb.label', default: 'Medplandb'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medplandb.label', default: 'Medplandb'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
