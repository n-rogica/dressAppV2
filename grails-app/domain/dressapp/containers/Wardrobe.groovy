package dressapp.containers

import groovy.transform.EqualsAndHashCode
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

    int clothesCount() {
      //esto no es muy elegante pero por la forma en que estan definidas
      //las abstracciones no se puede hacer un this.clothes,
      //para poder hacer eso habria que mover la coleccion del clothes manager/ClothesSuggester
      //a las clases wardrobe outfit y suitcase respectivamente
      def prendas = Clothes.findAllByWardrobe(this)
      return prendas.size()
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
