package dressapp.graph

import dressapp.clothes.Clothes
import dressapp.users.BodyPart
import dressapp.users.ColdResistance
import dressapp.users.Formality
import spock.lang.Specification

class GraphTest extends Specification {

    private Graph graph

    void setup() {
        graph = new Graph()
    }

    def "graphCreatedWithRoot"(){
        expect:
            this.graph.nodes.size() == 1
    }

    def "getRoot"(){
        expect:
            this.graph.getRoot().id == 0
    }

    def "getAdjacentsToNodeWithSpecificBodyPart"() {
        expect:
                this.graph.getAdjacentsToNodeWithSpecificBodyPart(this.graph.getRoot(), "CHEST").size() == 0

    }

    def "addAShirtTest"(){
        given:
            Clothes shirt1 = new Clothes('remera', BodyPart.CHEST,'red','algodon', ColdResistance.NOTHING, Formality.INFORMAL,
                'asd','M',null, null, null,null,null)
            this.graph.addCloth(shirt1)
        expect:
            this.graph.nodes.size() == 2
            this.graph.edges.size() == 1
    }

}
