import dressapp.clothes.Clothes

abstract class ClothesManager {  
  static hasMany = [clothes: Clothes]

  /*tal vez este metodo deberia recibir un map con los datos de la prenda
  (suponiendo que hay un form en el front) y que en la implementacion del metodo
  se llame al constructor de clothes, de esta forma las relaciones con el owner
  y el wardrobe en donde se encuentra la prenda se establecen directamente
  en el constructor de clothes en lugar de tener que setearlas a mano en
  la implementacion del metodo addClothes*/
  abstract def addClothes(Clothes clothesToAdd)
  abstract def deleteClothes(Clothes clothesToDelete)
}
