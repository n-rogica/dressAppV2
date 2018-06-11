package dressapp.users

class UserInfo {

  String name
  String lastName
  String address
  int age
  static belongsTo = [user: User] // esto hace que cuando borro user tambien se borre user info
  static hasOne = [bodyDescription: BodyDescription]


    static constraints = {
      name blank: false
      lastName blank:false
      address blank: false
      age blank: true, max: 99
    }

    UserInfo(User user) {
      this.name = 'asd'
      this.lastName = 'asd'
      this.address = 'asd'
      this.age = 21
      this.user = user
      this.bodyDescription = new BodyDescription(this)


    }
}
