package dressapp

import dressapp.users.*
import dressapp.clothes.*
import dressapp.containers.*

class BootStrap {

   def init = {
       servletContext ->
//      def user1 = new User('pepe','123456789').save(failOnError: true)
//      def prenda1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
//      ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
//      'ruta',user1, user1.wardrobe).save(failOnError: true)


    /*  Clothes(name, bodyPart, mainColour, fabric, coldResistance, formality,
        description, size, picture, owner, wardrobe) */

       User user = new User('admin', 'admin').save(failOnError: true)
       User admin = new User('agus', 'admin').save(failOnError: true)
       Role role = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
       UserRole.create(user,role)
       UserRole.create(admin,role)
           def prenda1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
      ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
      'ruta',user, user.wardrobe).save(failOnError: true)
           def prenda2 = new Clothes('buzo', BodyPart.SHOULDER, 'red','algodon',
                   ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
                   'ruta',user, user.wardrobe).save(failOnError: true)
           def prenda3 = new Clothes('saco', BodyPart.SHOULDER, 'red','algodon',
                   ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
                   'ruta',user, user.wardrobe).save(failOnError: true)
    }
    def destroy = {
    }
}
