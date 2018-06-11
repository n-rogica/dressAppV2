package dressapp

import dressapp.users.*
import dressapp.clothes.*
import dressapp.containers.*

class BootStrap {

   def init = { servletContext ->
      def user1 = new User('pepe','123456789').save()
    /*  def wardrobe = new Wardrobe(nombre: 'asd').save()
     def prenda = new Clothes(name: 'campera piola', mainColour: 'rojo',
      fabric: 'cuero', description: 'asd', brand: 'asd', size: 'm',
      picture: 'ruta a la foto', visibleToFriends: 'true', usesCount:'0',
       owner: user1, wardrobe: wardrobe).save()
       user1.addToWardrobe(wardrobe)*/


    }
    def destroy = {
    }
}
