package dressapp.containers

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SuitcaseController {

    SuitcaseService suitcaseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond suitcaseService.list(params), model:[suitcaseCount: suitcaseService.count()]
    }

    def show(Long id) {
        respond suitcaseService.get(id)
    }

    def create() {
        respond new Suitcase(params)
    }

    def save(Suitcase suitcase) {
        if (suitcase == null) {
            notFound()
            return
        }

        try {
            suitcaseService.save(suitcase)
        } catch (ValidationException e) {
            respond suitcase.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'suitcase.label', default: 'Suitcase'), suitcase.id])
                redirect suitcase
            }
            '*' { respond suitcase, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond suitcaseService.get(id)
    }

    def update(Suitcase suitcase) {
        if (suitcase == null) {
            notFound()
            return
        }

        try {
            suitcaseService.save(suitcase)
        } catch (ValidationException e) {
            respond suitcase.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'suitcase.label', default: 'Suitcase'), suitcase.id])
                redirect suitcase
            }
            '*'{ respond suitcase, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        suitcaseService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'suitcase.label', default: 'Suitcase'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'suitcase.label', default: 'Suitcase'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
