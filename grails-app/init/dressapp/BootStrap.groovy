package dressapp

import dressapp.users.*
import dressapp.clothes.*
import dressapp.containers.*
import dressapp.weather.*

import java.util.logging.Logger

class BootStrap {

   def init = {
       servletContext ->
//      def user1 = new User('pepe','123456789').save(failOnError: true)
//      def prenda1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
//      ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
//      'ruta',user1, user1.wardrobe).save(failOnError: true)


    /*  Clothes(name, bodyPart, mainColour, fabric, coldResistance, formality,
        description, size, picture, owner, wardrobe) */

       City city1 = new City("USA","Florida","Miami")
       City city2 = new City("Rusia","Leningrado","San Petersburgo")
       City city3 = new City("USA","Massachusetts","Boston")
       City city4 = new City("Argentina","Buenos Aires","CABA")

       generateWeatherDataFromFile(city1, 'grails-app/conf/bootData/climaMiami.csv')
       generateWeatherDataFromFile(city2, 'grails-app/conf/bootData/climaSanPetersburgo.csv')
       generateWeatherDataFromFile(city3, 'grails-app/conf/bootData/climaBoston.csv')
       generateWeatherDataFromFile(city4, 'grails-app/conf/bootData/climaCaba.csv')

       User agus = new User('agus', 'agus').save(failOnError: true)
       User admin = new User('admin', 'admin').save(failOnError: true)
       Role role = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
       UserRole.create(agus,role)
       UserRole.create(admin,role)

       def pictureBytes1 = new File('src/main/webapp/ropaAgus/camisaRayada.jpeg').bytes
       def pictureBytes2 = new File('src/main/webapp/ropaAgus/shortCuadriculado.jpeg').bytes
       def pictureBytes3 = new File('src/main/webapp/ropaAgus/pantLacosteVerde.jpeg').bytes

       List<Clothes> menShirts = generateClothesFromFile('grails-app/conf/bootData/prendasBA.csv',"camisasHombre", admin)
       List<Clothes> agusClothes = generateClothesFromFile('grails-app/conf/bootData/ropaAgus.csv',"ropaAgusToda", agus)
        agus.wardrobe.graph.save(failOnError: true)
           agusClothes.stream().forEach{cloth -> cloth.save(failOnError: true)
               agus.wardrobe.graph.addCloth(cloth)}
//       def prenda1 = new Clothes('remera',BodyPart.SHOULDER,'red','algodon',
//        ColdResistance.NOTHING,Formality.INFORMAL,'asd','M',pictureBytes1,
//               admin, admin.wardrobe).save(failOnError: true)
//       def prenda2 = new Clothes('buzo', BodyPart.SHOULDER, 'red','algodon',
//        ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',pictureBytes2,
//               admin, admin.wardrobe).save(failOnError: true)
//       def prenda3 = new Clothes('saco', BodyPart.SHOULDER, 'red','algodon',
//        ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M', pictureBytes3,
//               admin, admin.wardrobe).save(failOnError: true)
//
//
//           Outfit outfit = new Outfit("Barcito tranqui", admin.wardrobe)
//           outfit.addClothes(prenda1)
//           outfit.addClothes(prenda2)
//           outfit.addClothes(prenda3)
//           outfit.save(failOnError: true)

        new File('grails-app/conf/bootData/convertcsv.csv').eachCsvLine {tokens ->
          new User(tokens[0], tokens[1]).save(failOnError:true)}



    }

    private generateWeatherDataFromFile(City city, String weatherFile) {
      new File(weatherFile).eachCsvLine { tokens ->
          city.addWeather(new Weather(Date.parse('dd-MM-yyyy', tokens[0]), Float.parseFloat(tokens[1]), tokens[2]).save(failOnError: true))
      }
      city.save(failOnError: true)
    }

    private List<Clothes> generateClothesFromFile(String clothData, String pictureFile, User user) {
        List<Clothes> clothesList = new ArrayList<>()
        new File(clothData).eachCsvLine { tokens ->
            byte[] picture = resolvePicture(pictureFile, tokens[8])
            if(picture != null) {
                clothesList.add(new Clothes(tokens[0], BodyPart.valueOf(tokens[1]), tokens[2], tokens[3], ColdResistance.valueOf(tokens[4]), Formality.valueOf(tokens[5]),
                        tokens[6], tokens[7], picture, user, user.wardrobe, tokens[9], tokens[10]).save(failOnError: true))
            }
        }
        return clothesList
    }

    private byte[] resolvePicture(String picturesFile, String pictureName) {
        try {
            return new File('src/main/webapp/'+picturesFile+'/' + pictureName).bytes
        } catch (Exception e){
            return null
        }
    }
    def destroy = {
    }
}
