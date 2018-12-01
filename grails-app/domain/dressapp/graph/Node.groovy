package dressapp.graph

import dressapp.clothes.Clothes

class Node {

    int id
  //  static hasOne = [cloth: Clothes]
  Clothes cloth

    static constraints = {
      cloth nullable: true
    }

    Node(int id) {
        this.id = id
        this.cloth = null
    }

    Node(int id, Clothes cloth) {
        this.id = id
        this.cloth = cloth
    }

    boolean equals(Object obj) {
        if (this == obj) return true
        if (!(obj instanceof Node)) return false

        Node _obj = (Node) obj
        return _obj.id == this.id
    }

    int getId() {
        return this.id
    }

    void setId(int id) {
        this.id = id
    }  

//    List<Node> getAllThatGoesTo(String bodyPart) {
//        return edges.stream().filter{edge -> edge.endNode.cloth.bodyPart.name() == bodyPart}.map{edge -> edge.endNode}.collect()
//    }

}
