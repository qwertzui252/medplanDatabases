package medplandatabases

import grails.gorm.services.Service

@Service(Medplandb)
interface MedplandbService {

    Medplandb get(Serializable id)

    List<Medplandb> list(Map args)

    Long count()

    void delete(Serializable id)

    Medplandb save(Medplandb medplandb)

}