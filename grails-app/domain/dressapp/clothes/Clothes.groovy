package dressapp.clothes

import dressapp.users.User
import dressapp.containers.*

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
    String picture
    Status status
    boolean visibleToFriends
    int usesCount
    User owner
    static belongsTo = [wardrobe: Wardrobe]

    static constraints = {
      //todo revisar con la historia de usuario
      description blank: true
      brand blank: true
      usesCount display: false
      
    }

    static mapping = {
      visibleToFriends defaultValue: "0" //revisar esto
      usesCount defaultValue: "0"
      bodyPart enumType: 'string' //esto indica como se ve el enumerado en la base de datos
      coldResistance enumType: 'string'
      formality enumType: 'string'
      status enumType: 'string', defaultValue: "'AVAILABLE'"
    }
}
