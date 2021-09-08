package medplandatabases

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserdbServiceSpec extends Specification {

    UserdbService userdbService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Userdb(...).save(flush: true, failOnError: true)
        //new Userdb(...).save(flush: true, failOnError: true)
        //Userdb userdb = new Userdb(...).save(flush: true, failOnError: true)
        //new Userdb(...).save(flush: true, failOnError: true)
        //new Userdb(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userdb.id
    }

    void "test get"() {
        setupData()

        expect:
        userdbService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Userdb> userdbList = userdbService.list(max: 2, offset: 2)

        then:
        userdbList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userdbService.count() == 5
    }

    void "test delete"() {
        Long userdbId = setupData()

        expect:
        userdbService.count() == 5

        when:
        userdbService.delete(userdbId)
        sessionFactory.currentSession.flush()

        then:
        userdbService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Userdb userdb = new Userdb()
        userdbService.save(userdb)

        then:
        userdb.id != null
    }
}
