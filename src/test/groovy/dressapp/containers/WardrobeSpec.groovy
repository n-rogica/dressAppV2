package dressapp.containers

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

import dressapp.users.User
import dressapp.clothes.Clothes

class WardrobeSpec extends Specification implements DomainUnitTest<Wardrobe> {

    def setup() {
      def testUser1 = new User('pepe','pass1').save()
      
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
