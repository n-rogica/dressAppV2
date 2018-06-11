package dressapp.containers

import grails.gorm.services.Service

@Service(Wardrobe)
interface WardrobeService {

    Wardrobe get(Serializable id)

    List<Wardrobe> list(Map args)

    Long count()

    void delete(Serializable id)

    Wardrobe save(Wardrobe wardrobe)

}