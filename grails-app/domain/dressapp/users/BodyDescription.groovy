package dressapp.users

class BodyDescription {

    double height;
    double weight;
    double hipWidth;
    double legsLenght;
    double shoulderWidth;
    double feetSize;

    static constraints = {
      height blank: true, scale: 2
      weight  blank: true, scale: 2
      hipWidth blank: true, scale: 2
      legsLenght blank: true, scale: 2
      shoulderWidth  blank: true, scale: 2
      feetSize blank: true
    }
}
