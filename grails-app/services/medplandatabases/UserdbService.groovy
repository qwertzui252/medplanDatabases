package medplandatabases

import grails.gorm.services.Service

@Service(Userdb)
interface UserdbService {

    Userdb get(Serializable id)

    List<Userdb> list(Map args)

    Long count()

    void delete(Serializable id)

    Userdb save(Userdb userdb)

}