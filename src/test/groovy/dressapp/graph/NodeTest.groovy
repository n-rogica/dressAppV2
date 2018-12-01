package dressapp.graph

import spock.lang.Specification

class NodeTest extends Specification {

    private Node node

    void setup() {
        this.node = new Node(1)
    }

    def "NodeCreationTest"() {
        expect:
            this.node.id == 1
            this.node.cloth == null
    }

    def "AddingAnEdgeToTheNode"() {
        given:
            Edge edge1 = new Edge(new Node("A"), new Node("B"), 100)
            this.node.addEdge(edge1)
        expect:
            this.node.edges.size() == 1

    }
}
