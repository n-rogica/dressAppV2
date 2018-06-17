package dressapp

import dressapp.users.*
import dressapp.clothes.*
import dressapp.containers.*

class BootStrap {

   def init = { servletContext ->
      def user1 = new User('pepe','123456789').save(failOnError: true)
      def prenda1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
      ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
      'ruta',user1, user1.wardrobe).save(failOnError: true)


    /*  Clothes(name, bodyPart, mainColour, fabric, coldResistance, formality,
        description, size, picture, owner, wardrobe) */


    }
    def destroy = {
    }
}
