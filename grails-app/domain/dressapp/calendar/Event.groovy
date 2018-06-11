package dressapp.calendar

import dressapp.users.User
import dressapp.containers.Outfit

class Event {

    Date date
    //formality
    String description
    //cold resistance
    Outfit outfitForEvent

    static belongsTo = [user: User]

    static constraints = {
    }
}
