package dressapp.containers

import dressapp.clothes.Clothes
import dressapp.graph.Graph
import dressapp.users.User
import dressapp.weather.Weather
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='visibleToFriends,user,clothes,outfits,suitcases')
class Wardrobe extends ClothesSuggester {

    boolean visibleToFriends
    //modo
    static belongsTo = [user: User]
    static hasMany = [suitcases: Suitcase]
    static hasOne = [graph: Graph]

    static constraints = {
    }

    Wardrobe(User user) {
      this.user = user
      this.graph = new Graph()
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
        Outfit outfit = new Outfit("suggestion", this)
        Weather weather = new Weather(new Date(), 5, WeatherDescription.SNOWING)


        List<Clothes> shoes = getClothesFor("FEETS")
        List<Clothes> pants = getClothesFor("LEGS")
        List<Clothes> shirts = getClothesFor("CHEST")
        List<Clothes> hoodies = getClothesFor("CHEST2")
        List<Clothes> coats = getClothesFor("CHEST3")
        List<Clothes> hands = getClothesFor("HANDS")
        List<Clothes> neck = getClothesFor("NECK")
        List<Clothes> head = getClothesFor("HEAD")


        if(weather.temp <= 10){
            this.addRandomCloth(shirts,outfit)
            this.addRandomCloth(hoodies,outfit)
            this.addRandomCloth(coats,outfit)
            this.addRandomCloth(pants,outfit)
            this.addRandomCloth(shoes,outfit)
            if(WeatherDescription.SNOWING.name() == "SNOWING"){
                this.addRandomCloth(hands,outfit)
                this.addRandomCloth(neck,outfit)
                this.addRandomCloth(head,outfit)
            }
        }else if (weather.temp > 10 && weather.temp < 25){
            this.addRandomCloth(shirts,outfit)
            this.addRandomCloth(hoodies,outfit)
            this.addRandomCloth(pants,outfit)
            this.addRandomCloth(shoes,outfit)
        }else{
            this.addRandomCloth(shirts,outfit)
            this.addRandomCloth(hoodies,outfit)
            this.addRandomCloth(pants,outfit)
            this.addRandomCloth(shoes,outfit)
        }



      return outfit
    }

    List<Clothes> getClothesFor(String bodyPart){
        return this.clothes.stream().filter{cloth -> cloth.bodyPart.name() == bodyPart && cloth.formality.level >= 2  &&
                cloth.formality.level <= 4}.collect()
    }

    def addRandomCloth(List<Clothes> clothes, Outfit outfit){
        if(!clothes.isEmpty()) {
            Random random = new Random()
            int result = random.nextInt(clothes.size())

            outfit.addClothes(clothes.get(result))
        }
    }

    Clothes generateClothSuggestion() {
      return "cloth suggestion"
    }


}
