package dressapp.containers

import dressapp.clothes.Clothes
import dressapp.users.User


class Wardrobe extends ClothesSuggester {

    boolean visibleToFriends
    //modo
    static belongsTo = [user: User]
    static hasMany = [suitcases: Suitcase]

    static constraints = {
    }

    Wardrobe(User user) {
      this.user = user
      this.visibleToFriends = true //mover esto al static mapping
    }

    def addClothes(Clothes clothesToAdd) {
      this.addToClothes(clothesToAdd) //revisar
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
