package dressapp.weather

class City {

    String country
    String state
    String name
    List<Weather> weather
    //static hasMany = [weather: Weather]

    static constraints = {
      name blank: false
    }

    City(country, state, name ) {
      this.country = country
      this.state = state
      this.name = name
      weather = []
    }

    def addWeather(Weather weather) {
      this.weather.add(weather)
    }

    def getCityName() {
      return country +","+ state +"," + name
    }

    /*estos los puse a modo de ejemplo, la idea es que
    coleccion.find {} es equivalente a los streams de java8 asi que ahi adentro
    se puede filtrar por lo que uno quiera*/

    def getWeatherForDate(Date date) {
      return weather.find {it.date == date}

    }
    def getWeatherBetweenDates(Date startDate, Date endDate) {
      def res = weather.findAll {it -> it.date >= startDate && it.date <= endDate}
      print(res)
      return res
    }





}
