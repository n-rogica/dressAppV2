package dressapp.containers

import dressapp.clothes.Clothes

class Suitcase {

    String addresTo
    String fromDate
    String toDate
    boolean active

    static belongsTo = [wardrobe: Wardrobe]

    static constraints = {
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
