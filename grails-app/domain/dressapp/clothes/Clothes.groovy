package dressapp.clothes

import dressapp.users.User
import dressapp.containers.*
import src.main.groovy.*

class Clothes {

    String name
    BodyPart bodyPart
    String mainColour
    String fabric
    ColdResistance coldResistance
    Formality formality
    String description
    String brand
    String size
    byte[] picture
    Status status
    boolean visibleToFriends
    int usesCount
    User owner
    static belongsTo = [wardrobe: Wardrobe]

    static constraints = {
      //todo revisar con la historia de usuario
      description blank: true
      brand blank: true, nullable: true
      usesCount display: false
    }

    static mapping = {
      visibleToFriends defaultValue: "'TRUE'" //revisar esto
      usesCount defaultValue: "0"
      bodyPart enumType: 'string' //esto indica como se ve el enumerado en la base de datos
      coldResistance enumType: 'string'
      formality enumType: 'string'
      status enumType: 'string', defaultValue: "'AVAILABLE'" //revisar
      picture (type: 'image')
    }

    /*este es un constructor para poder hacer pruebas y hardcodear informacion
    en el archivo boostrap para que haya algo cuando inicia la aplicacion en la base de datos    */
    Clothes(name, bodyPart, mainColour, fabric, coldResistance, formality,
      description, size, pictureBytes, owner, wardrobe) {
        //en picture deberia venir o la tira de bytes, o el path a la ruta
        this.name = name
        this.bodyPart = bodyPart
        this.mainColour = mainColour
        this.fabric = fabric
        this.coldResistance = coldResistance
        this.formality = formality
        this.description = description
        this.size = size
        this.status = Status.AVAILABLE

        //lo que viene en picture es la tira de bytes
        this.picture = pictureBytes

        /*si lo que viene en picture es la ruta
        this.picture = new File(picture).bytes
        */

        this.owner = owner
        this.wardrobe = wardrobe
        this.wardrobe.clothes.add(this)
        this.visibleToFriends = true
        this.status = Status.AVAILABLE
    }





}
