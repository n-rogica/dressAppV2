package dressapp.users

import dressapp.containers.Wardrobe
import dressapp.calendar.Event

class User {

    String userName
    String password
    static hasOne = [userInfo: UserInfo, wardrobe: Wardrobe]
    static hasMany = [friends: User, events: Event]



    static constraints = {
      userName blank: false, unique: true
      password size: 5..15, blank: false, password: true
      friends nullable: true
    }

    User(userName, password) {
      /* este seria el constructor que se tiene que llamar al crear
      un usuario, en la pantalla de creacion de usuario aparte de pedir
      usuario y password deberia pedir los campos de userinfo y
      body description*/
      this.userName = userName
      this.password = password
      this.userInfo = new UserInfo(this)
      this.wardrobe = new Wardrobe(this)
    }

    def addFriend() {
        return "add friend"
    }

    def acceptFriend() {
      return "acceptFriend"
    }

  }
