enum ColdResistance {
  NOTHING(0),
  HOTSUMMER(1),
  WINDYSUNNY(2),
  SUMMERNIGHT(3),
  COLDSUMMER(4),
  MEDIUM(5),
  HUMIDWINTER(6),
  NEWWINTER(7),
  SNOWING(8),
  FREEZING(9),
  MAXIMUM(10),

  final int resistance

  ColdResistance(int resistance) {
    this.resistance = resistance
  }

}
