package dressapp.containers

import grails.gorm.services.Service

@Service(Outfit)
interface OutfitService {

    Outfit get(Serializable id)

    List<Outfit> list(Map args)

    Long count()

    void delete(Serializable id)

    Outfit save(Outfit outfit)

}