package dressapp.clothes

import grails.gorm.services.Service

@Service(Clothes)
interface ClothesService {

    Clothes get(Serializable id)

    List<Clothes> list(Map args)

    Long count()

    void delete(Serializable id)

    Clothes save(Clothes clothes)

}