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
            this.graph.edges.getAt(0).weight == 1
    }

    def "addTwoShirtTest"(){
        given:
        //setee los parametros que faltaban
        Clothes shirt1 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        Clothes shirt2 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        this.graph.addCloth(shirt1)
        this.graph.addCloth(shirt2)
        expect:
        this.graph.nodes.size() == 3
        this.graph.edges.size() == 2
        this.graph.edges.getAt(0).weight == 1
        this.graph.edges.getAt(1).weight == 1
    }

    def "usingCombinationChangesWeights"(){
        given:
        //setee los parametros que faltaban
        Clothes shirt1 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        Clothes shirt2 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        this.graph.addCloth(shirt1)
        this.graph.addCloth(shirt2)
        this.graph.useCombination(this.graph.getRoot(),this.graph.nodes.getAt(1))
        expect:
        this.graph.nodes.size() == 3
        this.graph.edges.size() == 2
        this.graph.edges.getAt(0).weight == 2
        this.graph.edges.getAt(1).weight == 1
    }

    def "connectWithAllWithTheSameBodyPart"(){
        Clothes shirt1 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        Clothes shirt2 = new Clothes('remera', "CHEST",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        Clothes buso1 = new Clothes('buso', "CHEST2",'red','algodon', "NOTHING", "INFORMAL",
                'asd','M','ruta', testUser1, testUser1.wardrobe,null,null).save(failOnError: true)
        this.graph.addCloth(shirt1)
        this.graph.addCloth(shirt2)
        this.graph.addCloth(buso1)
        expect:
        this.graph.nodes.size() == 4
        this.graph.edges.size() == 4


    }

    def cleanup() {
    }
}
