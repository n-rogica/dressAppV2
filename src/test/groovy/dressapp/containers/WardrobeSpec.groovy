package dressapp.containers

import grails.testing.gorm.DomainUnitTest
import grails.testing.gorm.DataTest
import spock.lang.Specification

import dressapp.users.User
import dressapp.clothes.Clothes

class WardrobeSpec extends Specification implements DomainUnitTest<Wardrobe>, DataTest {

  Class<?>[] getDomainClassesToMock(){
        return [User,Clothes] as Class[]
    }

    def testUser1
    def testUser2

    def setup() {
      testUser1 = new User('pepe','pass1').save()
      testUser2 = new User('paco','pass1').save()

    }

    def cleanup() {
    }

    void "test se agrega la cantidad correcta de prendas al guardarropas"() {
      given:
        def prenda1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
          ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
          'ruta',testUser1, testUser1.wardrobe).save(failOnError: true)
        def prenda2 = new Clothes('buzo', BodyPart.SHOULDER, 'red','algodon',
          ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
          'ruta',testUser1, testUser1.wardrobe).save(failOnError: true)
        def prenda3 = new Clothes('saco', BodyPart.SHOULDER, 'red','algodon',
          ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
          'ruta',testUser1, testUser1.wardrobe).save(failOnError: true)
        def prenda4 = new Clothes('saco', BodyPart.SHOULDER, 'red','algodon',
            ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
            'ruta',testUser2, testUser2.wardrobe).save(failOnError: true)
      expect:
            testUser1.wardrobe.clothesCount() == 3
    }

    void "test por defecto el wardrobe es publico para los amigos"() {
      expect:
            testUser1.wardrobe.visibleToFriends == true
    }

    void "test el wardrobe se puede volver privado"() {
      given:
        testUser1.makeWardrobePrivate()
      expect:
        testUser1.wardrobe.visibleToFriends == false
    }

    void "test por defecto el wardrobe no tiene suitcases"() {
      expect:
        testUser1.wardrobe.countSuitcases() == 0 &&
        testUser2.wardrobe.countSuitcases() == 0
    }

    void "test crear suitcase"() {
      given:
        testUser1.wardrobe.generateSuitcase("bariloche","27/9/2018","5/10/2018")

      expect:
        testUser1.wardrobe.countSuitcases() != 0 &&
        testUser1.wardrobe.countSuitcases() == 1
    }

    void "test se crea suitcase para el usuario correcto"() {
      given:
        testUser1.wardrobe.generateSuitcase("bariloche","27/9/2018","5/10/2018")

      expect:
        testUser2.wardrobe.countSuitcases() == 0
    }

    
}
