package dressapp.users

import grails.gorm.services.Service

@Service(BodyDescription)
interface BodyDescriptionService {

    BodyDescription get(Serializable id)

    List<BodyDescription> list(Map args)

    Long count()

    void delete(Serializable id)

    BodyDescription save(BodyDescription bodyDescription)

}