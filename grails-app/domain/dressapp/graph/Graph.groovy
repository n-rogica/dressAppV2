package dressapp.graph

import dressapp.clothes.Clothes
import dressapp.containers.Wardrobe

class Graph {

    static belongsTo = [wardrobe: Wardrobe]
  //  static hasMany = [nodes: Node]

    private HashSet<Edge> edges
    private Map<Node, Set<Edge>> adjList
    private HashSet<Node> nodes

    static constraints = {
    }

    Graph(wardrobe) {
        this.wardrobe = wardrobe
        nodes = new HashSet<>()
        edges = new HashSet<>()
        adjList = new HashMap<>()
        this.nodes.add(new Node(0))
    }

    boolean addNode(int label) {
        return nodes.add(new Node(label))
    }

    boolean addNode(Node v) {
        return nodes.add(v)
    }

    boolean addVertices(Collection<Node> nodes) {
        return this.nodes.addAll(nodes)
    }

    boolean removeNode(int label) {
        return nodes.remove(new Node(label))
    }

    boolean removeNode(Node v) {
        return nodes.remove(v)
    }

    boolean addEdge(Edge e) {
        if (!edges.add(e)) return false

        adjList.putIfAbsent(e.startNode, new HashSet<>())
        adjList.putIfAbsent(e.endNode, new HashSet<>())

        adjList.get(e.startNode).add(e)
        adjList.get(e.endNode).add(e)

        return true
    }

    boolean addEdge(int nodeLabel1, int nodeLabel2) {
        return addEdge(new Edge(new Node(nodeLabel1),
                new Node(nodeLabel2)))
    }

    boolean removeEdge(Edge e) {
        if (!edges.remove(e)) return false
        Set<Edge> edgesOfV1 = adjList.get(e.startNode)
        Set<Edge> edgesOfV2 = adjList.get(e.endNode)

        if (edgesOfV1 != null) edgesOfV1.remove(e)
        if (edgesOfV2 != null) edgesOfV2.remove(e)

        return true
    }

    boolean removeEdge(int nodeLabel1, int nodeLabel2) {
        return removeEdge(new Edge(new Node(nodeLabel1),
                new Node(nodeLabel2)))
    }

    Set<Node> getAdjVertices(Node v) {
        return adjList.get(v).stream()
                .map{e -> e.startNode.equals(v) ? e.endNode : e.startNode}
                .collect(Collectors.toSet())
    }

    Set<Node> getVertices() {
        return Collections.unmodifiableSet(nodes)
    }

    Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges)
    }

    Map<Node, Set<Edge>> getAdjList() {
        return Collections.unmodifiableMap(adjList)
    }


    Node getRoot() {
        return this.nodes.stream().filter{node -> node.id == 0}.findFirst().get()
    }

    Set<Edge> getAdjacentsToNodeWithSpecificBodyPart(Node v, String bodyPartName){
        return this.edges.stream().filter{
            edge -> edge.startNode.id == v.id && edge.endNode.cloth.bodyPart.name() == bodyPartName}.collect()
    }

    def addCloth(Clothes cloth){
        Node root = this.getRoot()

        if(cloth.bodyPart.name() == "CHEST"){
            Set<Edge> shirts = this.getAdjacentsToNodeWithSpecificBodyPart(root, "CHEST")
            Node newNode = new Node(shirts.size()+1, cloth)
            this.nodes.add(newNode)
            Edge newEdge = new Edge(root,newNode)
            this.updateProbabilities(newEdge, shirts)
            this.edges.add(newEdge)
        }
    }

    def updateProbabilities(Edge edge, Set<Edge> edges) {
        int amount = edges.size()
        double percentage = 100 / (amount + 1)
        for(Edge edgy: edges){
            edgy.setProbability(edgy.probability * (1 - percentage/100))
        }
        edge.setProbability(percentage)
    }
}
