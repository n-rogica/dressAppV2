package dressapp.users

class UserInfo {

  String name
  String lastName
  String address
  int age
  BodyDescription BodyDescription
  //idem user-userInfo 

    static constraints = {
      name blank: false
      lastName blank:false
      address blank: false
      age blank: true, max: 99
    }
}
