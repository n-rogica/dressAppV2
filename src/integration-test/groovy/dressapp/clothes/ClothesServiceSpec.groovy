package dressapp.clothes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClothesServiceSpec extends Specification {

    ClothesService clothesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Clothes(...).save(flush: true, failOnError: true)
        //new Clothes(...).save(flush: true, failOnError: true)
        //Clothes clothes = new Clothes(...).save(flush: true, failOnError: true)
        //new Clothes(...).save(flush: true, failOnError: true)
        //new Clothes(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //clothes.id
    }

    void "test get"() {
        setupData()

        expect:
        clothesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Clothes> clothesList = clothesService.list(max: 2, offset: 2)

        then:
        clothesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        clothesService.count() == 5
    }

    void "test delete"() {
        Long clothesId = setupData()

        expect:
        clothesService.count() == 5

        when:
        clothesService.delete(clothesId)
        sessionFactory.currentSession.flush()

        then:
        clothesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Clothes clothes = new Clothes()
        clothesService.save(clothes)

        then:
        clothes.id != null
    }
}
