package medplandatabases

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MedplandbServiceSpec extends Specification {

    MedplandbService medplandbService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Medplandb(...).save(flush: true, failOnError: true)
        //new Medplandb(...).save(flush: true, failOnError: true)
        //Medplandb medplandb = new Medplandb(...).save(flush: true, failOnError: true)
        //new Medplandb(...).save(flush: true, failOnError: true)
        //new Medplandb(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //medplandb.id
    }

    void "test get"() {
        setupData()

        expect:
        medplandbService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Medplandb> medplandbList = medplandbService.list(max: 2, offset: 2)

        then:
        medplandbList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        medplandbService.count() == 5
    }

    void "test delete"() {
        Long medplandbId = setupData()

        expect:
        medplandbService.count() == 5

        when:
        medplandbService.delete(medplandbId)
        sessionFactory.currentSession.flush()

        then:
        medplandbService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Medplandb medplandb = new Medplandb()
        medplandbService.save(medplandb)

        then:
        medplandb.id != null
    }
}
