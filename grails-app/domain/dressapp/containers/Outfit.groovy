package dressapp.containers

import dressapp.clothes.Clothes

class Outfit extends ClothesManager{

    String description
    int usesCount
    OutfitStatus outfitStatus
    static belongsTo = [wardrobe: Wardrobe]

    static constraints = {
    }

    static mapping = {
      outfitStatus enumType: 'string'
    }

    Outfit(String description, Wardrobe wardrobe) {
      this.description = description
      this.usesCount = 0
      this.clothes = []
      this.wardrobe = wardrobe
      this.outfitStatus = OutfitStatus.AVAILABLE
    }

    def use() {
      this.usesCount += 1
    }

    def reject(){
      println "reject"
    }

    def addClothes(Clothes clothesToAdd) {
      this.clothes.add(clothesToAdd)      
    }
    def deleteClothes(Clothes clothesToDelete) {
      return "borrando ropa"
    }


}
