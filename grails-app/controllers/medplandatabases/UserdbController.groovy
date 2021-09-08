package medplandatabases

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserdbController {

    UserdbService userdbService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userdbService.list(params), model:[userdbCount: userdbService.count()]
    }

    def show(Long id) {
        respond userdbService.get(id)
    }

    def create() {
        respond new Userdb(params)
    }

    def save(Userdb userdb) {
        if (userdb == null) {
            notFound()
            return
        }

        try {
            userdbService.save(userdb)
        } catch (ValidationException e) {
            respond userdb.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userdb.label', default: 'Userdb'), userdb.id])
                redirect userdb
            }
            '*' { respond userdb, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userdbService.get(id)
    }

    def update(Userdb userdb) {
        if (userdb == null) {
            notFound()
            return
        }

        try {
            userdbService.save(userdb)
        } catch (ValidationException e) {
            respond userdb.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userdb.label', default: 'Userdb'), userdb.id])
                redirect userdb
            }
            '*'{ respond userdb, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userdbService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userdb.label', default: 'Userdb'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userdb.label', default: 'Userdb'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
