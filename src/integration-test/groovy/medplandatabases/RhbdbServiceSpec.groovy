package medplandatabases

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RhbdbServiceSpec extends Specification {

    RhbdbService rhbdbService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rhbdb(...).save(flush: true, failOnError: true)
        //new Rhbdb(...).save(flush: true, failOnError: true)
        //Rhbdb rhbdb = new Rhbdb(...).save(flush: true, failOnError: true)
        //new Rhbdb(...).save(flush: true, failOnError: true)
        //new Rhbdb(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rhbdb.id
    }

    void "test get"() {
        setupData()

        expect:
        rhbdbService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rhbdb> rhbdbList = rhbdbService.list(max: 2, offset: 2)

        then:
        rhbdbList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rhbdbService.count() == 5
    }

    void "test delete"() {
        Long rhbdbId = setupData()

        expect:
        rhbdbService.count() == 5

        when:
        rhbdbService.delete(rhbdbId)
        sessionFactory.currentSession.flush()

        then:
        rhbdbService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rhbdb rhbdb = new Rhbdb()
        rhbdbService.save(rhbdb)

        then:
        rhbdb.id != null
    }
}
