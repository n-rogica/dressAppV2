package dressapp.users

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import dressapp.containers.Wardrobe

class UserSpec extends Specification implements DomainUnitTest<User> {

    def user1
    def user2


    def setup() {
        user1 = new User('pepe','pass1').save()
        user2 = new User('paco','pass2').save()
    }

    def cleanup() {
    }

    void "test se crean usuarios"() {
        expect:
          User.count() == 2
    }

    void "test al crear un usuario se asigna un userInfo"() {
        expect:
          UserInfo.count() == 2 && user1.userInfo != user2.userInfo
    }

    void "test al crear usuario se asigna un guardarropas"() {
        expect:
          Wardrobe.count() == 2
    }

    void "test se crean dos usuarios distintos"() {
      expect:
        user1 != user2
    }

    void "test dos usuarios tienen guardarropas distintos"() {
      expect:
        user1.wardrobe != user2.wardrobe
    }

    void "test el usuario creado no tiene amigos"() {
      expect:
        user1.friendsCount() == 0 && user2.friendsCount() == 0
    }

    void "test se pueden agregar amigos"() {
      given:
        user1.addFriend(user2)
        user1.addFriend(new User("asd","asd").save())
      expect:
        user1.friendsCount() == 2
    }

    void "test al agregar amigos se establece la relacion"() {
      given:
        user1.addFriend(user2)
      expect:
        user1.isFriend(user2)
    }




}
