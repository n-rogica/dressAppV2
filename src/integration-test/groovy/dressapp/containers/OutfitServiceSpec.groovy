package dressapp.containers

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OutfitServiceSpec extends Specification {

    OutfitService outfitService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Outfit(...).save(flush: true, failOnError: true)
        //new Outfit(...).save(flush: true, failOnError: true)
        //Outfit outfit = new Outfit(...).save(flush: true, failOnError: true)
        //new Outfit(...).save(flush: true, failOnError: true)
        //new Outfit(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //outfit.id
    }

    void "test get"() {
        setupData()

        expect:
        outfitService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Outfit> outfitList = outfitService.list(max: 2, offset: 2)

        then:
        outfitList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        outfitService.count() == 5
    }

    void "test delete"() {
        Long outfitId = setupData()

        expect:
        outfitService.count() == 5

        when:
        outfitService.delete(outfitId)
        sessionFactory.currentSession.flush()

        then:
        outfitService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Outfit outfit = new Outfit()
        outfitService.save(outfit)

        then:
        outfit.id != null
    }
}
