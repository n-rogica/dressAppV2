package dressapp.graph

class Edge {

    private static final int DEFAULT_WEIGHT = 1

    //static hasOne = [startNode: Node, endNode: Node]
    Node startNode
    Node endNode
    double weight

    Edge(Node startNode, Node endNode) {
        this(startNode, endNode, DEFAULT_WEIGHT)
    }

    Edge(Node startNode, Node endNode, int weight) {
        super()
        this.startNode = startNode
        this.endNode = endNode
        this.weight = weight
    }

    boolean equals(Object obj) {
        if (this == obj) return true
        if (!(obj instanceof Edge)) return false

        Edge _obj = (Edge) obj
        return _obj.startNode.equals(startNode) && _obj.endNode.equals(endNode) &&
                _obj.weight == weight
    }

    int hashCode() {
        int result = startNode.hashCode()
        result = 31 * result + endNode.hashCode()
        result = 31 * result + weight
        return result
    }

    def use(){
        this.weight = this.weight + 1
    }
}
