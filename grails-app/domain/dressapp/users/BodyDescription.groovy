package dressapp.users

class BodyDescription {

    double height
    double weight
    double hipWidth
    double legsLenght
    double shoulderWidth
    double feetSize
    static belongsTo = [userInfo: UserInfo]

    static constraints = {
      height blank: true, scale: 2
      weight  blank: true, scale: 2
      hipWidth blank: true, scale: 2
      legsLenght blank: true, scale: 2
      shoulderWidth  blank: true, scale: 2
      feetSize blank: true
    }

    BodyDescription(UserInfo userInfo) {
      this.height = 1.80
      this.weight = 80
      this.hipWidth = 80
      this.legsLenght = 80
      this.shoulderWidth = 80
      this.feetSize = 40
      this.userInfo = userInfo
    }


}
