package dressapp.clothes

import dressapp.users.User
import dressapp.containers.Wardrobe

import grails.testing.gorm.DomainUnitTest
import grails.testing.gorm.DataTest
import spock.lang.Specification


class ClothesSpec extends Specification implements DomainUnitTest<Clothes> {

    def testUser1
    def testUser2
    def testClothes1

    def setup() {
      testUser1 = new User('pepe','pass1').save()
      testUser2 = new User('paco','pass1').save()
    /*  testClothes1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
        ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
        'ruta',testUser1, testUser1.wardrobe,null,null).save(failOnError: true)*/
    }

    def cleanup() {
    }

    void "test se crea una prenda"() {
        expect:
            Clothes.count() == 1 && testUser1.wardrobe.clothesCount() == 1
    }

    void "test se crea la prenda para el usuario correcto"() {
      expect:
          Clothes.count() == 1 && testUser2.wardrobe.clothesCount() == 0
    }

    void "test se asigna el owner de la prenda correctamente"() {
      expect:
        testClothes1.owner == testUser1 && testClothes1.owner != testUser2
    }

    void "test la prenda creada se encuentra en el wardrobe del usuario correcto"() {
      expect:
        testClothes1.wardrobe == testUser1.wardrobe &&
        testClothes1.wardrobe != testUser2.wardrobe
    }


}
