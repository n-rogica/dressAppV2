package dressapp.clothes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClothesController {

    ClothesService clothesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond clothesService.list(params), model:[clothesCount: clothesService.count()]
    }

    def show(Long id) {
        respond clothesService.get(id)
    }

    def create() {
        respond new Clothes(params)
    }

    def save(Clothes clothes) {
        if (clothes == null) {
            notFound()
            return
        }

        try {
            clothesService.save(clothes)
        } catch (ValidationException e) {
            respond clothes.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'clothes.label', default: 'Clothes'), clothes.id])
                redirect clothes
            }
            '*' { respond clothes, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond clothesService.get(id)
    }

    def update(Clothes clothes) {
        if (clothes == null) {
            notFound()
            return
        }

        try {
            clothesService.save(clothes)
        } catch (ValidationException e) {
            respond clothes.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clothes.label', default: 'Clothes'), clothes.id])
                redirect clothes
            }
            '*'{ respond clothes, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        clothesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'clothes.label', default: 'Clothes'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clothes.label', default: 'Clothes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
