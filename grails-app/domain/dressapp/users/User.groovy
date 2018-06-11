package dressapp.users

class User {

    String userName
    String password
    static hasOne = [userInfo: UserInfo]
    /*no me parecio que fuera necesario plasmar la relacion entre
    user y userInfo en forma explicita en la base de datos, así como está ahora
    en la tabla de usuarios se guarda el id de la instancia de UserInfo
    correspondiente y se puede acceder a los métodos o atributos de userInfo
    sin problemas desde la vista con un usuario.userInfo.metodo() o
    usuario.userInfo.nombreDelCampo.*/

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
