package dressapp.weather

import grails.testing.gorm.DomainUnitTest
import grails.testing.gorm.DataTest
import spock.lang.Specification

class WeatherSpec extends Specification implements DomainUnitTest<Weather> {

    def testWeather1
    def testWeather2

    def setup() {
      testWeather1 = new Weather(Date.parse('dd-MM-yyyy', "01-12-2018"), 30, WeatherDescription.SUNNY).save()
      testWeather2 = new Weather(Date.parse('dd-MM-yyyy', "24-12-2018"), 18, WeatherDescription.RAINING).save()
    }

    def cleanup() {
    }

    void "test se crean climas"() {
        expect:
            Weather.count() == 2
    }

    void "test el constructor setea correctamente los parametros"() {
        expect:
            testWeather1.date == Date.parse('dd-MM-yyyy', "01-12-2018") &&
            testWeather1.temp == 30 &&
            testWeather1.description == WeatherDescription.SUNNY

    }
}
