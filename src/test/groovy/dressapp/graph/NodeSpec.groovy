package dressapp.graph

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class NodeSpec extends Specification implements DomainUnitTest<Edge> {

  private Node node

  void setup() {
      node = new Node(1).save(failOnError: true)
  }

  def "NodeCreationTest"() {
      expect:
          node.id == 1
          node.cloth == null
  }

    def cleanup() {
    }
}
