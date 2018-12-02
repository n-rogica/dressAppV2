package dressapp.users

import dressapp.calendar.Event
import dressapp.containers.Wardrobe
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    boolean dressed


    static hasOne = [userInfo: UserInfo, wardrobe: Wardrobe]
    static hasMany = [friends: User, events: Event]

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }


    static constraints = {
      username nullable: false, blank: false, unique: true
      password nullable: false, blank: false, password: true
      friends nullable: true
    }

    User(username, password) {
      /* este seria el constructor que se tiene que llamar al crear
      un usuario, en la pantalla de creacion de usuario aparte de pedir
      usuario y password deberia pedir los campos de userinfo y
      body description*/
      this.username = username
      this.password = password
      this.userInfo = new UserInfo(this)
      this.wardrobe = new Wardrobe(this)
        this.dressed = false
    }

    def setDressed(boolean dressed){
        this.dressed = dressed
    }

    def addFriend(User otherUser) {
        this.addToFriends(otherUser)
        if (!otherUser.isFriend(this)) {
          otherUser.addToFriends(this)
        }
    }

    def removeFriend(User otherUser) {
      if (this.friends != null) {
        this.removeFromFriends(otherUser)
      }

      if (otherUser.friends != null) {
        otherUser.removeFromFriends(this)
      }
    }

    boolean isFriend(User otherUser) {
      if (this.friends == null) {
        return false
      }
      return this.friends.contains(otherUser)
    }

    void makeWardrobePrivate() {
      this.wardrobe.visibleToFriends = false
    }

    void makeWardrobePublic() {
      this.wardrobe.visibleToFriends = true
    }

    boolean isWardrobePublic() {
      return this.wardrobe.visibleToFriends
    }

    int friendsCount() {
      return this.friends?.size() ?: 0
    }

    static mapping = {
        password column: '`password`'
    }

  }
