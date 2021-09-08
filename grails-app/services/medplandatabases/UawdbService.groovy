package medplandatabases

import grails.gorm.services.Service

@Service(Uawdb)
interface UawdbService {

    Uawdb get(Serializable id)

    List<Uawdb> list(Map args)

    Long count()

    void delete(Serializable id)

    Uawdb save(Uawdb uawdb)

}