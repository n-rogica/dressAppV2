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


    /*para poder levantar las imagenes de una carpeta lo ideal es trabajar en dos pasos:
          - en un primer momento hay que levantar el directorio con todas las imagenes (esto podría hacerse por ejemplo
            cuando se accede al index de wardrobe, se levantan todas las fotos del usuario que esta logueado y se empiezan
            a mostrar por pantalla)
          - en una segunda instancia hay que llamar al metodo que muestre una foto específica, pasandole un parametro desde la vista
      */

      def getAllImages() {
        /*este seria el paso uno, en donde se levanta la carpeta y se las devuelve como una lista de imagenes, esto debería estar
        definido en el metodo index del controlador que necesita mostrar muchas fotos*/
        private static final File IMAGES_DIR = new File('/src/main/webapp') //levanto la carpeta
              [images: IMAGES_DIR.listFiles()] // 'images' es la variable que el controlador le pasa a la vista con la lista de archivos
      }

      def displayImage() {
        /* este es el segundo paso, el metodo que meustra propiamente la imagen, es similar a lo que se hace en
        en el metodo show image solo que aca el new File() lo hace con una ruta que le viene desde la vista
        en la variable params.img*/
        File image = new File(params.img) //params es una variable de groovy que se carga y se envía desde la vista, 'img' es el nombre que le puse a la variable en la vista
        if(!image.exists()) {
          println "Foto ${params.img} no encontrada"
          response.status = 404
          return
        }
        //se encontro la foto
        response.setHeader('Cache-Control', 'no-cache')
        response.contentType = '/image/jpeg' //adaptar segun se necesite
        response.outputStream << image.bytes
        response.outputStream.flush()
      }

      /* en el gsp esto se implementa de la siguiente manera
      suponiendo que la logica del paso esta definida en el metodo index la vista
      ya tiene disponible en una variable 'images' una lista de todas las fotos, (caso contrario
      habría que definir un link al action que trae todas las imagenes previamente)

      una vez que tengo toda la lista de fotos con el metodo g:each ciclo por todos los elementos
      de la lista 'images'
      <g:each in="${images}" var="img">
      <img src='${createLink(controller: "home", action: "displayImage", params:[img: img.path])}' />
      </g:each>

      params es un map de tipo clave, valor que se usa para mandarle información al controlador
      en este caso el map params tiene un solo elemento con clave 'img' y valor img.path

      img.path me da la ruta completa de la foto, si usara img.name solo me daria el nombre del archivo
      esto puede ser util si llegado el momento hay que levantar distintas fotos de distintos lugares
      y no se quiere comprometer el metodo a una sola implementacion
      */
}
