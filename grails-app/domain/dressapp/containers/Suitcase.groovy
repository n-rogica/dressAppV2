package dressapp.containers

import dressapp.clothes.Clothes

class Suitcase extends ClothesSuggester{

    String addresTo
    String fromDate
    String toDate
    boolean active

    static belongsTo = [wardrobe: Wardrobe]

    static constraints = {
    }

    Suitcase(String addresTo, String fromDate, String toDate,
       Wardrobe wardrobe) {
      this.addresTo = addresTo
      this.fromDate = new Date().parse("yyyy-MM-dd", fromDate)
      this.toDate = new Date().parse("yyyy-MM-dd", toDate)
      this.wardrobe = wardrobe
      this.clothes = wardrobe.clothes
      this.outfits =  wardrobe.outfits
      this.active = true //revisar
    }

    def addClothes(Clothes clothesToAdd) {
      return "agregando ropa"
    }
    def deleteClothes(Clothes clothesToDelete) {
      return "borrando ropa"
    }

    Outfit generateSuggestion() {
      return "outfit suggestion"
    }

    Clothes generateClothSuggestion() {
      return "cloth suggestion"
    }
}
