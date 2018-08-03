package dressapp.containers

import groovy.transform.EqualsAndHashCode
import dressapp.clothes.Clothes
import dressapp.users.User

@EqualsAndHashCode(includes='visibleToFriends,user,clothes,outfits,suitcases')
class Wardrobe extends ClothesSuggester {

    boolean visibleToFriends
    //modo
    static belongsTo = [user: User]
    static hasMany = [suitcases: Suitcase]

    static constraints = {
    }

    Wardrobe(User user) {
      this.user = user
      this.clothes = []
      this.outfits = []
      this.visibleToFriends = true //mover esto al static mapping
    }

    def addClothes(Clothes clothesToAdd) {
      this.addToClothes(clothesToAdd) //revisar
      return "agregando ropa"
    }
    def deleteClothes(Clothes clothesToDelete) {
      return "borrando ropa"
    }

    int clothesCount() {
      //forma vieja, cuando las clases abstractas no tenian las listas
      //def prendas = Clothes.findAllByWardrobe(this)
      //return prendas.size()

      return this.clothes.size()
    }

    int countSuitcases() {
      return this.suitcases?.size() ?: 0
    }

    void generateSuitcase(String address, String fromDate, String toDate) {
      this.addToSuitcases(new Suitcase(address,fromDate,toDate,this))
    }

    Outfit generateSuggestion() {
      return "outfit suggestion"
    }

    Clothes generateClothSuggestion() {
      return "cloth suggestion"
    }


}
