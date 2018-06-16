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
      visibleToFriends defaultValue: "TRUE" //revisar esto
      usesCount defaultValue: "0"
      bodyPart enumType: 'string' //esto indica como se ve el enumerado en la base de datos
      coldResistance enumType: 'string'
      formality enumType: 'string'
      status enumType: 'string', defaultValue: "'AVAILABLE'"
    }

    Clothes(name, bodyPart, mainColour, fabric, coldResistance, formality,
      description, size, picture, owner, wardrobe) {
        this.name = name
        this.bodyPart = bodyPart
        this.mainColour = mainColour
        this.fabric = fabric
        this.coldResistance = coldResistance
        this.formality = formality
        this.description = description
        this.size = size
        this.picture = picture
        this.owner = owner
        this.wardrobe = wardrobe
      }

}
