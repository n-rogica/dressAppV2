package dressapp.containers

import dressapp.clothes.Clothes

class Outfit extends ClothesManager{

    String description
    int usesCount
    OutfitStatus outfitStatus
    static belongsTo = [wardrobe: Wardrobe]
    boolean visible

    static constraints = {
    }

    static mapping = {
      outfitStatus enumType: 'string'
    }

    Outfit(String description, Wardrobe wardrobe) {
      this.description = description
      this.usesCount = 0
      this.clothes = []
      wardrobe.outfits.add(this)
      this.wardrobe = wardrobe
      this.outfitStatus = OutfitStatus.AVAILABLE
      this.visible = false
    }

    Outfit(String description, Wardrobe wardrobe, List<Clothes> clothes) {
        this.description = description
        this.usesCount = 0
        this.clothes = clothes
        wardrobe.outfits.add(this)
        this.wardrobe = wardrobe
        this.outfitStatus = OutfitStatus.AVAILABLE
        this.visible = false
    }

    def setVisible(boolean visible){
        this.visible = visible
    }

    def use() {
      this.usesCount += 1
    }

    def clothesCount() {
      return this.clothes.size()
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
