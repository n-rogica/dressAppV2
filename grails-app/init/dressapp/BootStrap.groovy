package dressapp

import dressapp.users.*

class BootStrap {

    def init = { servletContext ->
      def userInfo1 = new UserInfo(name:'paco', lastName:'asd', address: 'asda', age: '1').save()
      def user1 = new User(userName:'pepe', password:'12345', userInfo: userInfo1).save()


    }
    def destroy = {
    }
}
