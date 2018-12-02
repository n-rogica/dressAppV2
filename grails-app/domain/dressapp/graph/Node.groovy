package dressapp.graph

import dressapp.clothes.Clothes

class Node {

    int nodeId
  //  static hasOne = [cloth: Clothes]
  Clothes cloth
  // dejo esto por las dudas
  //static belongsTo = [graph: Graph]
  Graph graph

    static constraints = {
      cloth nullable: true
    }

    // idem el belongsTo
    Node(int id, Graph graph) {
        this.nodeId = id
        this.cloth = null
        this.graph = graph
    }

    Node(int id, Clothes cloth, Graph graph) {
        this.nodeId = id
        this.cloth = cloth
        this.graph = graph
    }
    /*
    Node(int id) {
        this.id = id
        this.cloth = null
    }

    Node(int id, Clothes cloth) {
        this.id = id
        this.cloth = cloth
    }*/


    boolean equals(Object obj) {
        if (this == obj) return true
        if (!(obj instanceof Node)) return false

        Node _obj = (Node) obj
        return _obj.nodeId == this.nodeId
    }

    int getNodeId() {
        return this.nodeId
    }

    void setNodeId(int id) {
        this.nodeId = nodeId
    }

}
