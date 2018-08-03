package dressapp.containers

import dressapp.users.User
import dressapp.clothes.Clothes

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OutfitSpec extends Specification implements DomainUnitTest<Outfit> {

    def testUser1
    def testUser2
    def testClothes1
    def testOutfit1


    def setup() {
      testUser1 = new User('pepe','pass1').save()
      testUser2 = new User('paco','pass1').save()
      testClothes1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
        ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
        'ruta',testUser1, testUser1.wardrobe).save(failOnError: true)
      testOutfit1 = new Outfit("", testUser1.wardrobe)
    }

    def cleanup() {
    }

    def "test se crea un outfit"() {
      expect:
        Outfit.count() == 1
    }

    def "test el outfit creado se encuentra en el wardrobe del usuario correcto"() {
      expect:
        testOutfit1.wardrobe == testUser1.wardrobe && testOutfit1.wardrobe != testUser2.wardrobe
    }

    def "test el outfit creado no tiene usos"() {
      expect:
        testOutfit1.usesCount == 0
    }

    def "test el outfit se crea sin prendas"()  {
      expect:
        testOutfit1.clothesCount() == 0
    }

    def "test se agregan prendas al outfit"() {
      given:
        testOutfit1.addClothes(testClothes1)
      expect:
        testOutfit1.clothesCount() == 1
    }

    def "test la prenda agregada al outfit sigue estando en el guardarropas"() {
      given:
        testOutfit1.addClothes(testClothes1)
      expect:
        testUser1.clothesCount() == 1 && testClothes1.owner == testUser1
    }

    def "test se aumenta la cantidad de usos del outfit"() {
      given:
        testOutfit1.use()
      expect:
        testUser1.usesCount == 1
    }


}
