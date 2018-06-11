package dressapp.users

class User {

    String userName
    String password
    static hasOne = [userInfo: UserInfo]

    static constraints = {
      userName blank: false, unique: true
      password size: 5..15, blank: false, password: true
    }

    User(userName, password) {
      this.userName = userName
      this.password = password
      this.userInfo = new UserInfo(this)
    }

  }
