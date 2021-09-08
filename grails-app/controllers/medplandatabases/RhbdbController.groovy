package medplandatabases

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RhbdbController {

    RhbdbService rhbdbService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rhbdbService.list(params), model:[rhbdbCount: rhbdbService.count()]
    }

    def show(Long id) {
        respond rhbdbService.get(id)
    }

    def create() {
        respond new Rhbdb(params)
    }

    def save(Rhbdb rhbdb) {
        if (rhbdb == null) {
            notFound()
            return
        }

        try {
            rhbdbService.save(rhbdb)
        } catch (ValidationException e) {
            respond rhbdb.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rhbdb.label', default: 'Rhbdb'), rhbdb.id])
                redirect rhbdb
            }
            '*' { respond rhbdb, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rhbdbService.get(id)
    }

    def update(Rhbdb rhbdb) {
        if (rhbdb == null) {
            notFound()
            return
        }

        try {
            rhbdbService.save(rhbdb)
        } catch (ValidationException e) {
            respond rhbdb.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rhbdb.label', default: 'Rhbdb'), rhbdb.id])
                redirect rhbdb
            }
            '*'{ respond rhbdb, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rhbdbService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rhbdb.label', default: 'Rhbdb'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rhbdb.label', default: 'Rhbdb'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
