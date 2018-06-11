package dressapp.containers

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WardrobeController {

    WardrobeService wardrobeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond wardrobeService.list(params), model:[wardrobeCount: wardrobeService.count()]
    }

    def show(Long id) {
        respond wardrobeService.get(id)
    }

    def create() {
        respond new Wardrobe(params)
    }

    def save(Wardrobe wardrobe) {
        if (wardrobe == null) {
            notFound()
            return
        }

        try {
            wardrobeService.save(wardrobe)
        } catch (ValidationException e) {
            respond wardrobe.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'wardrobe.label', default: 'Wardrobe'), wardrobe.id])
                redirect wardrobe
            }
            '*' { respond wardrobe, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond wardrobeService.get(id)
    }

    def update(Wardrobe wardrobe) {
        if (wardrobe == null) {
            notFound()
            return
        }

        try {
            wardrobeService.save(wardrobe)
        } catch (ValidationException e) {
            respond wardrobe.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'wardrobe.label', default: 'Wardrobe'), wardrobe.id])
                redirect wardrobe
            }
            '*'{ respond wardrobe, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        wardrobeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'wardrobe.label', default: 'Wardrobe'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'wardrobe.label', default: 'Wardrobe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
