package medplandatabases

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AmdbServiceSpec extends Specification {

    AmdbService amdbService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Amdb(...).save(flush: true, failOnError: true)
        //new Amdb(...).save(flush: true, failOnError: true)
        //Amdb amdb = new Amdb(...).save(flush: true, failOnError: true)
        //new Amdb(...).save(flush: true, failOnError: true)
        //new Amdb(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //amdb.id
    }

    void "test get"() {
        setupData()

        expect:
        amdbService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Amdb> amdbList = amdbService.list(max: 2, offset: 2)

        then:
        amdbList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        amdbService.count() == 5
    }

    void "test delete"() {
        Long amdbId = setupData()

        expect:
        amdbService.count() == 5

        when:
        amdbService.delete(amdbId)
        sessionFactory.currentSession.flush()

        then:
        amdbService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Amdb amdb = new Amdb()
        amdbService.save(amdb)

        then:
        amdb.id != null
    }
}
