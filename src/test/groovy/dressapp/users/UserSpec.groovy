package dressapp.users

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import dressapp.containers.Wardrobe

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
      def testUser1 = new User('pepe','pass1').save()
      def testUser2 = new User('paco','pass2').save()
    }

    def cleanup() {
    }

    void "test se crean usuarios"() {
        expect:
          User.count() == 2
    }

    void "test al crear un usuario se asigna un userInfo"() {
        expect:
          UserInfo.count() == 2
    }

    void "test al crear usuario se asigna un guardarropas"() {
        expect:
          Wardrobe.count() == 2
    }

    void "test se crean dos usuarios distintos"() {
      given:
        def u1 = User.findByUserName('pepe')
        def u2 = User.findByUserName('paco')

      expect:
        u1 != u2
    }

    void "test dos usuarios tienen guardarropas distintos"() {
      given:
        def u1 = User.findByUserName('pepe')
        def u2 = User.findByUserName('paco')

      expect:
        u1.wardrobe != u2.wardrobe
    }
}
