package dressapp.graph

class Edge {

    private static final int DEFAULT_WEIGHT = 100

    static hasOne = [startNode: Node, endNode: Node]
    double probability

    Edge(Node startNode, Node endNode) {
        this(startNode, endNode, DEFAULT_WEIGHT)
    }

    Edge(Node startNode, Node endNode, int probability) {
        super()
        this.startNode = startNode
        this.endNode = endNode
        this.probability = probability
    }

    boolean equals(Object obj) {
        if (this == obj) return true
        if (!(obj instanceof Edge)) return false

        Edge _obj = (Edge) obj
        return _obj.startNode.equals(startNode) && _obj.endNode.equals(endNode) &&
                _obj.probability == probability
    }

    int hashCode() {
        int result = startNode.hashCode()
        result = 31 * result + endNode.hashCode()
        result = 31 * result + probability
        return result
    }
}
