package dressapp

import dressapp.users.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class HomeController {

    def index() {
      String loggedUserName = getPrincipal().username
      def loggedUser = User.findByUsername(loggedUserName)
      if (loggedUser == null) {
        render "no encontro al usuario"
        return
      }
      render (view: 'index.gsp', model:[loggedUser: loggedUser])
    }
}
