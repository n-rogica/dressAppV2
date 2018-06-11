package dressapp.users

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BodyDescriptionController {

    BodyDescriptionService bodyDescriptionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bodyDescriptionService.list(params), model:[bodyDescriptionCount: bodyDescriptionService.count()]
    }

    def show(Long id) {
        respond bodyDescriptionService.get(id)
    }

    def create() {
        respond new BodyDescription(params)
    }

    def save(BodyDescription bodyDescription) {
        if (bodyDescription == null) {
            notFound()
            return
        }

        try {
            bodyDescriptionService.save(bodyDescription)
        } catch (ValidationException e) {
            respond bodyDescription.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bodyDescription.label', default: 'BodyDescription'), bodyDescription.id])
                redirect bodyDescription
            }
            '*' { respond bodyDescription, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bodyDescriptionService.get(id)
    }

    def update(BodyDescription bodyDescription) {
        if (bodyDescription == null) {
            notFound()
            return
        }

        try {
            bodyDescriptionService.save(bodyDescription)
        } catch (ValidationException e) {
            respond bodyDescription.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bodyDescription.label', default: 'BodyDescription'), bodyDescription.id])
                redirect bodyDescription
            }
            '*'{ respond bodyDescription, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bodyDescriptionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bodyDescription.label', default: 'BodyDescription'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bodyDescription.label', default: 'BodyDescription'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
