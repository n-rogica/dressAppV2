package dressapp

import dressapp.users.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class HomeController {

    def index() {
        def user = User.findByUsername("agus")
        if (user == null) {
            render "error"
        } else {
            render (view: "index.gsp", model:[user: user])
        }


    }
}
