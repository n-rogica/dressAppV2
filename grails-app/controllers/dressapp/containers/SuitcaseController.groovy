package dressapp.containers

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured("ROLE_ADMIN")
class SuitcaseController {

    SuitcaseService suitcaseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        List<String> categories = ["SPORTS", "RUNNING", "TENNIS", "FOOTBALL", "HOME", "EVERYDAY", "NIGHT_OUT", "WORK",
                                   "ELEGANT_SPORT", "VERY_ELEGANT", "WATER", "BEACH", "MOUNTAIN", "SNOW", "RAIN"]
        respond suitcaseService.list(params), model:[categories: categories]
    }

    def suggestion(){
        String categoriesString = ""
        String whereTo = params.get("where")
        String fromDate = params.get("trip-start")
        String toDate = params.get("trip-end")
        String amount = params.get("quantity")
        List<String> categories = params.get("category")
        if(categories){
            categoriesString = categories.join(",")
        }
        Wardrobe wardrobe = dressapp.users.User.findByUsername(getPrincipal().username).getWardrobe()

        Suitcase suitcase = new Suitcase(whereTo,fromDate, toDate, wardrobe)

        respond suitcaseService.list(params), model:[suitcase: suitcase, amount: amount, categories: categories]
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

    def showImage() {
        File file = new File('src/main/webapp/maleta.jpg')
        showImg(file)

    }

    def showImage2() {
        File file = new File('src/main/webapp/maleta2.png')
        showImg(file)
    }

    def showImg(File fileImage){
        response.setHeader('Cache-Control', 'no-cache')
        response.contentType = '/image/jpeg' /*adaptar al tipo necesario*/
        response.outputStream << fileImage.bytes
        response.outputStream.flush()
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
