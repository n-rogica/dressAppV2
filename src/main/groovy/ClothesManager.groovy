import dressapp.clothes.Clothes

abstract class ClothesManager {
  static hasMany = [clothes: Clothes]

  abstract def addClothes(Clothes clothesToAdd)
  abstract def deleteClothes(Clothes clothesToDelete)
}
