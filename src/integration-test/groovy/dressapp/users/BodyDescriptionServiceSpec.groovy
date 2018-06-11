package dressapp.users

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BodyDescriptionServiceSpec extends Specification {

    BodyDescriptionService bodyDescriptionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new BodyDescription(...).save(flush: true, failOnError: true)
        //new BodyDescription(...).save(flush: true, failOnError: true)
        //BodyDescription bodyDescription = new BodyDescription(...).save(flush: true, failOnError: true)
        //new BodyDescription(...).save(flush: true, failOnError: true)
        //new BodyDescription(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bodyDescription.id
    }

    void "test get"() {
        setupData()

        expect:
        bodyDescriptionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<BodyDescription> bodyDescriptionList = bodyDescriptionService.list(max: 2, offset: 2)

        then:
        bodyDescriptionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bodyDescriptionService.count() == 5
    }

    void "test delete"() {
        Long bodyDescriptionId = setupData()

        expect:
        bodyDescriptionService.count() == 5

        when:
        bodyDescriptionService.delete(bodyDescriptionId)
        sessionFactory.currentSession.flush()

        then:
        bodyDescriptionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        BodyDescription bodyDescription = new BodyDescription()
        bodyDescriptionService.save(bodyDescription)

        then:
        bodyDescription.id != null
    }
}
