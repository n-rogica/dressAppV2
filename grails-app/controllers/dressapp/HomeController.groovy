package dressapp

import dressapp.users.User
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.core.io.Resource
import org.springframework.core.io.ByteArrayResource

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

    /*este metodo muestra fotos cuando lo llamas*/
    def showImage() {
    File file = new File('src/main/webapp/image.jpeg') /*si le saco mas cosas al path no lo encuentra*/
    /*response es una variable propia del controller que provee groovy, hay distintos tipos, model, message, flash, cada una tiene una función diferente*/
    response.setHeader('Cache-Control', 'no-cache') /*esto creo que se puede modificar, vi distintos ejemplos con distintas cosas en el header*/
    response.contentType = '/image/jpeg' /*adaptar al tipo necesario*/
    response.outputStream << file.bytes
    response.outputStream.flush()

    /* en el .gsp se agrega la siguiente linea:
      <img src="${createLink(controller: 'home', action: 'showImage')}"/>
      */
   }

   
    /*esto que sigue aca es otra opcion, no devuelve la imagen, sino que la muestra por completo en la pagina*/
    def renderImage() {
      File file = new File('src/main/webapp/image.jpeg')
      Resource image = new ByteArrayResource(file.getBytes())
      render file: image.inputStream, contentType: 'image/jpeg'
      /*este action hay que usarlo con una url completa*/
    }





}
