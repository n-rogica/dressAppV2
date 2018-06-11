import dressapp.clothes.Clothes
import dressapp.containers.Outfit

abstract class ClothesSuggester extends ClothesManager {

  static hasMany = [outfits: Outfit]

  abstract Outfit generateSuggestion()
  abstract Clothes generateClothSuggestion()
}
