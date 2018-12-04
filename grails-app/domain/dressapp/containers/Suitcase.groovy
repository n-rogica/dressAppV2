package dressapp.containers

import dressapp.clothes.Clothes
import dressapp.weather.Weather

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
      this.clothes = this.generate(wardrobe)
      this.outfits =  this.generateSuggestionss(wardrobe)
      this.active = true //revisar
    }

    List<Clothes> generate(Wardrobe wardrobe) {
        List<Clothes> clothes1 = wardrobe.clothes
        List<Clothes> clothesGenerate = new ArrayList<>()
        int size = clothes1.size()


        List<Clothes> shoes = getClothesFor(clothes1,"FEETS")
        List<Clothes> pants = getClothesFor(clothes1,"LEGS")
        List<Clothes> shirts = getClothesFor(clothes1,"CHEST")
        List<Clothes> hoodies = getClothesFor(clothes1,"CHEST2")
        List<Clothes> coats = getClothesFor(clothes1,"CHEST3")
        List<Clothes> hands = getClothesFor(clothes1,"HANDS")
        List<Clothes> neck = getClothesFor(clothes1,"NECK")
        List<Clothes> head = getClothesFor(clothes1,"HEAD")


        this.addRandomClothes(12,shirts,clothesGenerate)
        this.addRandomClothes(5,pants,clothesGenerate)
        this.addRandomClothes(3,shoes,clothesGenerate)
        this.addRandomClothes(2,hoodies,clothesGenerate)
        this.addRandomClothes(1,coats,clothesGenerate)
        this.addRandomClothes(1,neck,clothesGenerate)
        this.addRandomClothes(1,head,clothesGenerate)


        return clothesGenerate
    }

    def addRandomClothes(int amount, List<Clothes> listCloth, ArrayList<Clothes> gen) {
        Random rand = new Random()
        for(int i = 0; i < amount; i ++){
            int size = listCloth.size()
            if(size > 0) {
                Clothes cloth = listCloth.get(rand.nextInt(size))
                listCloth.remove(cloth)
                gen.add(cloth)
            }
        }

    }

    List<Clothes> getClothesFor(List<Clothes> clothess, String bodyPart){
        return clothess.stream().filter{cloth -> cloth.bodyPart.name() == bodyPart && cloth.formality.level >= 2  &&
                cloth.formality.level <= 4}.collect()
    }

    List<Outfit> generateSuggestionss(Wardrobe wardrobe) {
        List<Outfit> outfitList = new ArrayList<>()
        int i = 0
        while (i < 20){
            outfitList.add(this.generateOutfit(wardrobe, i))
            i++
        }
        return outfitList
    }

    Outfit generateOutfit(Wardrobe wardrobe, int size) {
        Outfit outfit = new Outfit("Sugerencia "+size, wardrobe)
        List<String> weathers = ["SUNNY",
                                 "RAINING",
                                 "CLOUDY",
                                 "SNOW",
                                 "HAIL_STORM",
                                 "STORM"]
        Random rand = new Random()
        int randWeather = rand.nextInt(weathers.size())
        int randTemp = rand.nextInt(10)+1
        Weather weather = new Weather(new Date(), randTemp, WeatherDescription.valueOf(weathers.get(randWeather)))

//        List<Node> nodes = this.graph.getSuggestion(3)
//        nodes.stream().map{node -> node.cloth}.forEach{cloth -> outfit.addClothes(cloth)}

        List<Clothes> shoes = getClothesFor(this.clothes,"FEETS")
        List<Clothes> pants = getClothesFor(this.clothes,"LEGS")
        List<Clothes> shirts = getClothesFor(this.clothes,"CHEST")
        List<Clothes> hoodies = getClothesFor(this.clothes,"CHEST2")
        List<Clothes> coats = getClothesFor(this.clothes,"CHEST3")
        List<Clothes> hands = getClothesFor(this.clothes,"HANDS")
        List<Clothes> neck = getClothesFor(this.clothes,"NECK")
        List<Clothes> head = getClothesFor(this.clothes,"HEAD")


        if(weather.temp <= 10){
            this.addRandomCloth(shirts,outfit)
            this.addRandomCloth(hoodies,outfit)
            this.addRandomCloth(coats,outfit)
            this.addRandomCloth(pants,outfit)
            this.addRandomCloth(shoes,outfit)
            if(weathers.get(randWeather) == "SNOW"){
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

    def addRandomCloth(List<Clothes> clothes, Outfit outfit){
        if(!clothes.isEmpty()) {
            Random random = new Random()
            int result = random.nextInt(clothes.size())

            outfit.addClothes(clothes.get(result))
        }
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
