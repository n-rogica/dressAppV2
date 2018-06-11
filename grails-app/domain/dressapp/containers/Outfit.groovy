package dressapp.containers

import dressapp.clothes.Clothes

class Outfit extends ClothesManager{

    String description
    int usesCount
    //status
    static belongsTo = [wardrobe: Wardrobe]

    static constraints = {
    }

    def use() {
      this.usesCount += 1
    }

    def reject(){
      println "reject"
    }

    def addClothes(Clothes clothesToAdd) {
      this.addToClothes(clothesToAdd) //revisar
      return "agregando ropa"
    }
    def deleteClothes(Clothes clothesToDelete) {
      return "borrando ropa"
    }
}
