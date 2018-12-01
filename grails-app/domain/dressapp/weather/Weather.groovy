package dressapp.weather

import groovy.transform.EqualsAndHashCode
import src.main.groovy.*

@EqualsAndHashCode(includes='date,temp,description')
class Weather {

    Date date
    float temp
    WeatherDescription description

    static constraints = {
      date blank: false
      temp blank: false
    }

    static mapping = {
      description enumType: 'string'
    }

    Weather(date, temp, description) {
      this.date = date
      this.temp = temp
      this.description = description
    }


}
