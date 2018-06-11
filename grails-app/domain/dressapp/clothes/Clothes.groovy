package dressapp.clothes

import dressapp.users.User

class Clothes {

    String name
    //bodypart
    String mainColour
    String fabric
    //coldResistance
    //formality
    String description
    String brand
    String size
    String picture
    //state
    boolean visibleToFriends
    int usesCount
    User owner

    static constraints = {
      //todo revisar con la historia de usuario
      description blank: true
      brand blank: true
      usesCount display: false
      visibleToFriends display: false
    }

    static mapping = {
      visibleToFriends defaultValue: "'true'" //revisar esto
      usesCount defaultValue: "0"

    }
}
