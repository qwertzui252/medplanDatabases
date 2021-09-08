package medplandatabases

import grails.gorm.services.Service

@Service(Amdb)
interface AmdbService {

    Amdb get(Serializable id)

    List<Amdb> list(Map args)

    Long count()

    void delete(Serializable id)

    Amdb save(Amdb amdb)

}