import dressapp.clothes.Clothes



abstract class ClothesManager {
  static hasMany = [clothes: Clothes]

  def abstract addClothes(Clothes clothesToAdd)
  def abstract deleteClothes(Clothes clothesToDelete)
}
