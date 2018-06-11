package dressapp.containers

import grails.gorm.services.Service

@Service(Suitcase)
interface SuitcaseService {

    Suitcase get(Serializable id)

    List<Suitcase> list(Map args)

    Long count()

    void delete(Serializable id)

    Suitcase save(Suitcase suitcase)

}