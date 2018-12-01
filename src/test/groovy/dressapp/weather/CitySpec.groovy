package dressapp.weather

import grails.testing.gorm.DomainUnitTest
import grails.testing.gorm.DataTest
import spock.lang.Specification

class CitySpec extends Specification implements DomainUnitTest<City> {

    def testCity1
    def testCity2
    def testWeather1
    def testWeather2
    def weatherList

    def setup() {
      testCity1 = new City("USA","Florida","Miami").save()
      testCity2 = new City("Rusia","Leningrado","San Petersburgo").save()
      testWeather1 = new Weather(Date.parse('dd-MM-yyyy', "01-12-2018"), 30, WeatherDescription.SUNNY).save()
      testWeather2 = new Weather(Date.parse('dd-MM-yyyy', "24-12-2018"), 18, WeatherDescription.RAINING).save()
    }

    def cleanup() {
    }

    void "test se crean ciudades"() {
        expect:
            City.count == 2
    }

    void "test las ciudades creadas no tienen climas"() {
        expect:
            testCity1.weather.size() == 0 &&
            testCity2.weather.size() == 0
    }

    void "test se setea correctamente pais, estado y nombre en el constructor" () {
      given:
         def testCity3 = new City("USA","Florida","Orlando").save()

      expect:
          testCity1.country == "USA" &&
          testCity1.state == "Florida" &&
          testCity1.name == "Miami"
          testCity3.country == "USA" &&
          testCity3.state == "Florida" &&
          testCity3.name == "Orlando"
    }

    void "test se devuelve el nombre de la ciudad con el formato correcto"() {
        expect:
            testCity1.getCityName() == "USA,Florida,Miami" &&
            testCity2.getCityName() == "Rusia,Leningrado,San Petersburgo"

    }

    void "test se agrega clima a la ciudad correcta"() {
        given:
            testCity1.addWeather(testWeather1)
            testCity1.addWeather(testWeather2)
        expect:
            testCity1.weather.size() == 2 &&
            testCity2.weather.size() == 0
    }

    void "test se pide el clima para una fecha "() {
        given:
            testCity1.addWeather(testWeather1)
        expect:
            testWeather1 == testCity1.getWeatherForDate(Date.parse('dd-MM-yyyy', "01-12-2018"))

    }

    void "test se pide el clima para una fecha2 "() {
        given:
            testCity1.addWeather(testWeather1)
            testCity1.addWeather(testWeather2)
            weatherList = testCity1.getWeatherBetweenDates(Date.parse('dd-MM-yyyy', "01-12-2018"),
            Date.parse('dd-MM-yyyy', "24-12-2018"))
        expect:            
            weatherList.size() == 2 && weatherList[0] == testWeather1 &&
            weatherList[1] == testWeather2

    }






}
