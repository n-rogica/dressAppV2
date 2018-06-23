package dressapp.containers

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

import dressapp.users.*
import dressapp.clothes.Clothes


class WardrobeSpec extends Specification implements DomainUnitTest<Wardrobe> {

    def setup() {
      def testUser1 = new User('pepe','pass1').save()
        def prenda1 = new Clothes('remera', BodyPart.SHOULDER, 'red','algodon',
                ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
                'ruta',user, user.wardrobe).save(failOnError: true)
        def prenda2 = new Clothes('buzo', BodyPart.SHOULDER, 'red','algodon',
                ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
                'ruta',user, user.wardrobe).save(failOnError: true)
        def prenda3 = new Clothes('saco', BodyPart.SHOULDER, 'red','algodon',
                ColdResistance.NOTHING, Formality.INFORMAL, 'asd','M',
                'ruta',user, user.wardrobe).save(failOnError: true)
      
    }

    def cleanup() {
    }

    void "test hay 3 prendas"() {
        expect:
            Clothes.count() == 3
    }
}
