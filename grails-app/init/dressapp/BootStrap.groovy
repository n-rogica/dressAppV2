package dressapp

import dressapp.users.*

class BootStrap {

   def init = { servletContext ->
  /*    def BodyDescription1 = new BodyDescription(height: '1,80', weight: '80',
          hipWidth: '80', legsLenght: '80', shoulderWidth: '80',
          feetSize: '40').save()
      def userInfo1 = new UserInfo(name:'paco', lastName:'asd',
          address: 'asda', age: '18', BodyDescription: BodyDescription1).save()
      def user1 = new User(userName:'pepe', password:'12345', userInfo: userInfo1).save()

*/
      def user1 = new User('pepe','123456789').save()
    }
    def destroy = {
    }
}
