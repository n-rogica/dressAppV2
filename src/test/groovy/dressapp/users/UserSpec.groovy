package dressapp.users

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test se crean usuarios"() {
        setup:
        new User('abc','abcdef').save()


        expect:
            User.count() == 1
    }

    void "cantidad de user info"() {
        setup:
        def a = new User('abc','abcdef').save()


        expect:
            UserInfo.count() == 1
    }

    void "el user info es el que corresponde al usuario"() {
      setup:
      new User('abc','abcdef').save()
      new User('abcde','abcdef').save()
      def b = UserInfo.getAll()

      expect:
      b.size() == 2


    }
}
