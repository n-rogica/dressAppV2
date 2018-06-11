package dressapp.containers

import dressapp.clothes.Clothes
import dressapp.users.User


class Wardrobe extends ClothesManager {

    String nombre

    static constraints = {
    }

    def addClothes(Clothes clothesToAdd) {
      this.addToClothes(clothesToAdd) //revisar
      return "agregando ropa"
    }
    def deleteClothes(Clothes clothesToDelete) {      
      return "borrando ropa"
    }
}
