package medplandatabases

import grails.gorm.services.Service

@Service(Rhbdb)
interface RhbdbService {

    Rhbdb get(Serializable id)

    List<Rhbdb> list(Map args)

    Long count()

    void delete(Serializable id)

    Rhbdb save(Rhbdb rhbdb)

}