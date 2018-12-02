package dressapp.graph

import dressapp.users.ColdResistance
import dressapp.users.Formality
import dressapp.users.User
import dressapp.clothes.Clothes
import dressapp.containers.Wardrobe

//faltaban estos imports
import grails.testing.gorm.DomainUnitTest
import grails.testing.gorm.DataTest
import spock.lang.Specification
//el implements tambien
class GraphSpec extends Specification implements DomainUnitTest<Graph> {

    private Graph graph
    //agregue esta variable
    def testUser1

    void setup() {
        testUser1 = new User('pepe','pass1').save()
        graph = new Graph(testUser1.wardrobe)
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
            //setee los parametros que faltaban
            Clothes shirt1 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
            this.graph.addCloth(shirt1)
        expect:
            this.graph.nodes.size() == 2
            this.graph.edges.size() == 1
    }

    def cleanup() {
    }
}
