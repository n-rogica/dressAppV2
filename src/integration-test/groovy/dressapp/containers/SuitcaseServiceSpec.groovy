package dressapp.containers

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SuitcaseServiceSpec extends Specification {

    SuitcaseService suitcaseService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Suitcase(...).save(flush: true, failOnError: true)
        //new Suitcase(...).save(flush: true, failOnError: true)
        //Suitcase suitcase = new Suitcase(...).save(flush: true, failOnError: true)
        //new Suitcase(...).save(flush: true, failOnError: true)
        //new Suitcase(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //suitcase.id
    }

    void "test get"() {
        setupData()

        expect:
        suitcaseService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Suitcase> suitcaseList = suitcaseService.list(max: 2, offset: 2)

        then:
        suitcaseList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        suitcaseService.count() == 5
    }

    void "test delete"() {
        Long suitcaseId = setupData()

        expect:
        suitcaseService.count() == 5

        when:
        suitcaseService.delete(suitcaseId)
        sessionFactory.currentSession.flush()

        then:
        suitcaseService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Suitcase suitcase = new Suitcase()
        suitcaseService.save(suitcase)

        then:
        suitcase.id != null
    }
}
