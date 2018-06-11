package dressapp.containers

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OutfitController {

    OutfitService outfitService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond outfitService.list(params), model:[outfitCount: outfitService.count()]
    }

    def show(Long id) {
        respond outfitService.get(id)
    }

    def create() {
        respond new Outfit(params)
    }

    def save(Outfit outfit) {
        if (outfit == null) {
            notFound()
            return
        }

        try {
            outfitService.save(outfit)
        } catch (ValidationException e) {
            respond outfit.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'outfit.label', default: 'Outfit'), outfit.id])
                redirect outfit
            }
            '*' { respond outfit, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond outfitService.get(id)
    }

    def update(Outfit outfit) {
        if (outfit == null) {
            notFound()
            return
        }

        try {
            outfitService.save(outfit)
        } catch (ValidationException e) {
            respond outfit.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'outfit.label', default: 'Outfit'), outfit.id])
                redirect outfit
            }
            '*'{ respond outfit, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        outfitService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'outfit.label', default: 'Outfit'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'outfit.label', default: 'Outfit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
