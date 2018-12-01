import dressapp.clothes.Clothes

abstract class ClothesManager {
  /*esta lista y la de outfits en  pueden o no estar,
  en algunos casos por ahi aceleran el proceso de busqueda, por ejemplo
  para los outfits con la lista uno sabe rapidamente cuales son las prendas
  que lo componene, en cambio usando directamente la relacion hay que
  laburar un poco porque habria que hacer algo como
  def listaPrendasDelOutfit = Clothes.findAllBySarasa()
  o meter una consulta directamente
  */
  List<Clothes> clothes
  static hasMany = [clothes: Clothes]

  /*me parece que aca se tendria que definir otro metodo addClothes que reciba
  un map con los valores, suponiendo que desde el front viene un form, ya que
  por la restriccion de las relaciones en la base de datos, una prenda
  tiene que tener designada un owner y un wardrobe al cual pertenecen
  esto obliga de alguna manera a asignar en el constructor de clothes
  estas variables/relaciones por lo que para el caso del wardrobe se vuelve redundante
  el hecho de que exista este metodo. Este no es el caso para la valija
  y los conjuntos. En esos casos si es coherente indicar cual es la prenda
  porque se supone que ya esta creada. Tambien se podría quitar esta restriccion
  y que una prenda se pueda crear con owner y wardrobe en null y asumir que nunca
  va a intentar guardarse en la base de datos una prenda en esas condiciones*/
  abstract def addClothes(Clothes clothesToAdd)
  abstract def deleteClothes(Clothes clothesToDelete)
}
