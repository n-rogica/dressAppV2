package dressapp.containers

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WardrobeServiceSpec extends Specification {

    WardrobeService wardrobeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Wardrobe(...).save(flush: true, failOnError: true)
        //new Wardrobe(...).save(flush: true, failOnError: true)
        //Wardrobe wardrobe = new Wardrobe(...).save(flush: true, failOnError: true)
        //new Wardrobe(...).save(flush: true, failOnError: true)
        //new Wardrobe(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //wardrobe.id
    }

    void "test get"() {
        setupData()

        expect:
        wardrobeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Wardrobe> wardrobeList = wardrobeService.list(max: 2, offset: 2)

        then:
        wardrobeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        wardrobeService.count() == 5
    }

    void "test delete"() {
        Long wardrobeId = setupData()

        expect:
        wardrobeService.count() == 5

        when:
        wardrobeService.delete(wardrobeId)
        sessionFactory.currentSession.flush()

        then:
        wardrobeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Wardrobe wardrobe = new Wardrobe()
        wardrobeService.save(wardrobe)

        then:
        wardrobe.id != null
    }
}
