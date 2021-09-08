package medplandatabases

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AmdbController {

    AmdbService amdbService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond amdbService.list(params), model:[amdbCount: amdbService.count()]
    }

    def show(Long id) {
        respond amdbService.get(id)
    }

    // method to search per pZN
    def searchByPZN(String pZN) {
        //def b = Amdb.findByPZN($pZN)
        //def b = Amdb.findByPZN("15893535")
        def b = Amdb.findByPZN("$pZN")
        respond b
    }

    // method to search per Handelsname
    def searchByHandelsname(String Handelsname) {
        //def b = Amdb.findByPZN("METAMIZOL AbZ 500 mg Tabletten")
        def b = Amdb.findByHandelsname("$Handelsname")
        respond b
    }


    // method to search per unscharf Handelsname
    def searchByName(String Handelsname) {
        //def b = Amdb.findByHandelsnameIlike("METAMIZOL")
        def b = Amdb.findAllByHandelsnameIlike("$Handelsname%")

        respond b
    }

    def create() {
        respond new Amdb(params)
    }

    def save(Amdb amdb) {
        if (amdb == null) {
            notFound()
            return
        }

        try {
            amdbService.save(amdb)
        } catch (ValidationException e) {
            respond amdb.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'amdb.label', default: 'Amdb'), amdb.id])
                redirect amdb
            }
            '*' { respond amdb, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond amdbService.get(id)
    }

    def update(Amdb amdb) {
        if (amdb == null) {
            notFound()
            return
        }

        try {
            amdbService.save(amdb)
        } catch (ValidationException e) {
            respond amdb.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'amdb.label', default: 'Amdb'), amdb.id])
                redirect amdb
            }
            '*'{ respond amdb, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        amdbService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'amdb.label', default: 'Amdb'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'amdb.label', default: 'Amdb'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
