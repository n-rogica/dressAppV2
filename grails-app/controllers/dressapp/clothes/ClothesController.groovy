package dressapp.clothes

import dressapp.users.User

//ESTE IMPORT ES NECESARIO PARA LOS ENUMERADOS
import src.main.groovy.*

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured("ROLE_ADMIN")
class ClothesController {

    ClothesService clothesService
    Set<String> setHead = ["gorra", "sombrero"].toSet()
    Set<String> setNeck = ["bufanda"].toSet()
    Set<String> setChest = ["remera manga corta", "remera manga larga",
     "camisa manga corta", "camisa manga larga", "pullover", "buzo", "campera",
     "campera de lluvia", "saco"].toSet()
    Set<String> setChestAbrigo = ["pullover", "buzo", "campera", "saco"].toSet()
    Set<String> setHands = ["guantes"].toSet()
    Set<String> setLegs = ["short", "bermuda", "jean", "joggin",
     "pantalon corto", "pantalon largo", "pantalon de vestir"].toSet()
     Set<String> setLegsAbrigo = ["jean", "joggin",
      "pantalon largo", "pantalon de vestir"].toSet()
    Set<String> setFeets = ["zapatillas", "zapatos", "ojotas", "sandalias"].toSet()
    Set<String> setColor = ["white", "black", "blue", "red", "light blue", "pink", "brown"].toSet()
    Random random = new Random()

    def prendasHead() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      def nombrePrenda
      BodyPart bodyPart
      def color
      def fabric
      def coldResistance
      def formality
      def description
      def size = "M"
      def ruta = ""

      for (def i = 0; i < 10; i++) {
        nombrePrenda = setHead[random.nextInt(setHead.size())]
        bodyPart = BodyPart.HEAD
        color = setColor[random.nextInt(setColor.size())]
        fabric = ""
        description = nombrePrenda
        if (random.nextInt(1) == 0) {
          coldResistance = ColdResistance.values()[random.nextInt(2)]
          formality = Formality.values()[random.nextInt(2)]
          clothesService.save(new Clothes(nombrePrenda, bodyPart, color, fabric, coldResistance, formality, description, size, ruta, loggedUser, loggedUser.wardrobe))
        }
      }
      render "se crearon las prendasHead"
    }

    def prendasNeck() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      def nombrePrenda
      BodyPart bodyPart
      def color
      def fabric
      def coldResistance
      def formality
      def description
      def size = "M"
      def ruta = ""

      for (def i = 0; i < 10; i++) {
        nombrePrenda = setNeck[random.nextInt(setNeck.size())]
        bodyPart = BodyPart.NECK
        color = setColor[random.nextInt(setColor.size())]
        fabric = ""
        description = nombrePrenda
        if (random.nextInt(1) == 0) {
          coldResistance = ColdResistance.values()[random.nextInt(4)+ 1]
          formality = Formality.values()[random.nextInt(3)+ 1]
          clothesService.save(new Clothes(nombrePrenda, bodyPart, color, fabric, coldResistance, formality, description, size, ruta, loggedUser, loggedUser.wardrobe))
        }
      }
      render "se crearon las prendasNeck"
    }

    def prendasHands() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      def nombrePrenda
      BodyPart bodyPart
      def color
      def fabric
      def coldResistance
      def formality
      def description
      def size = "M"
      def ruta = ""

      for (def i = 0; i < 10; i++) {
        nombrePrenda = setHands[random.nextInt(setHands.size())]
        bodyPart = BodyPart.HANDS
        color = setColor[random.nextInt(setColor.size())]
        fabric = ""
        description = nombrePrenda
        if (random.nextInt(1) == 0) {
          coldResistance = ColdResistance.values()[random.nextInt(4)+ 2]
          formality = Formality.values()[random.nextInt(3)+ 1]
          clothesService.save(new Clothes(nombrePrenda, bodyPart, color, fabric, coldResistance, formality, description, size, ruta, loggedUser, loggedUser.wardrobe))
        }
      }
      render "se crearon las prendasHands"
    }


    def prendasChest() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      def nombrePrenda
      BodyPart bodyPart
      def color
      def fabric
      def coldResistance
      def formality
      def description
      def size = "M"
      def ruta = ""

      for (def i = 0; i < 10; i++) {
        nombrePrenda = setChest[random.nextInt(setChest.size())]
        bodyPart = BodyPart.CHEST
        color = setColor[random.nextInt(setColor.size())]
        fabric = "algodon"
        description = nombrePrenda
        if (setChestAbrigo.contains(nombrePrenda)) {
            coldResistance = ColdResistance.values()[random.nextInt(4) + 6]
        } else {
           coldResistance = ColdResistance.values()[random.nextInt(4)]
        }
        formality = Formality.values()[random.nextInt(5)]
        clothesService.save(new Clothes(nombrePrenda, bodyPart, color, fabric, coldResistance, formality, description, size, ruta, loggedUser, loggedUser.wardrobe))
      }
      render "se crearon las prendasChest"
    }

    def prendasLegs() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      def nombrePrenda
      BodyPart bodyPart
      def color
      def fabric
      def coldResistance
      def formality
      def description
      def size = "M"
      def ruta = ""

      for (def i = 0; i < 10; i++) {
        nombrePrenda = setLegs[random.nextInt(setLegs.size())]
        bodyPart = BodyPart.LEGS
        color = setColor[random.nextInt(setColor.size())]
        fabric = ""
        description = nombrePrenda
        if (setLegsAbrigo.contains(nombrePrenda)) {
            coldResistance = ColdResistance.values()[random.nextInt(4) + 6]
        } else {
           coldResistance = ColdResistance.values()[random.nextInt(4)]
        }
        formality = Formality.values()[random.nextInt(5)]
        clothesService.save(new Clothes(nombrePrenda, bodyPart, color, fabric, coldResistance, formality, description, size, ruta, loggedUser, loggedUser.wardrobe))
      }
      render "se crearon las prendasLegs"
    }

    def prendasFeets() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      def nombrePrenda
      BodyPart bodyPart
      def color
      def fabric
      def coldResistance
      def formality
      def description
      def size = "M"
      def ruta = ""

      for (def i = 0; i < 10; i++) {
        nombrePrenda = setFeets[random.nextInt(setFeets.size())]
        bodyPart = BodyPart.FEETS
        color = setColor[random.nextInt(setColor.size())]
        fabric = ""
        description = nombrePrenda
        coldResistance = ColdResistance.values()[random.nextInt(4)]
        formality = Formality.values()[random.nextInt(3)]
        clothesService.save(new Clothes(nombrePrenda, bodyPart, color, fabric, coldResistance, formality, description, size, ruta, loggedUser, loggedUser.wardrobe))
      }
      render "se crearon las prendasFeets"
    }

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond clothesService.list(params), model:[clothesCount: clothesService.count()]
    }

    def mostramePrendas(String userName){
        def user = User.findByUsername("agus")
        def clothes = Clothes.findByUser(user)
        print "asd"

    }

    def addClothes() {
      println "controller add clothes llegaron estos parametros ${params}"
      render "action add clothes"
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
