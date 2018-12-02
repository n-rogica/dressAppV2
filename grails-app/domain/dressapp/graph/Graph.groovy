package dressapp.graph

import dressapp.clothes.Clothes
import dressapp.containers.Wardrobe

class Graph {

  //  static belongsTo = [wardrobe: Wardrobe]
    /* dejo esto por las dudas
    static hasMany = [nodes: Node]*/

    private HashSet<Edge> edges
    private Map<Node, Set<Edge>> adjList
    private HashSet<Node> nodes
    private Wardrobe wardrobe

    static constraints = {
    }

    Graph(wardrobe) {
        this.wardrobe = wardrobe
        nodes = new HashSet<>()
        edges = new HashSet<>()
        adjList = new HashMap<>()
        this.addNode(new Node(0, this).save(failOnError: true))
    }

    boolean addNode(int label) {
        return nodes.add(new Node(label, this).save(failOnError: true))
    }

    boolean addNode(Node v) {
      //  println("cant nodos " + nodes.size())
        def res = nodes.add(v)
      //  println("cant nodos despues del add " + nodes.size())
      //  println ("valor de res: " + res)
        return res
    }

    boolean addVertices(Collection<Node> nodes) {
        return this.nodes.addAll(nodes)
    }
/*
    boolean removeNode(int label) {
        return nodes.remove(new Node(label, this))
    }

    boolean removeNode(Node v) {
        return nodes.remove(v)
    }*/

    boolean addEdge(Edge e) {
        if (!edges.add(e)) return false

        adjList.putIfAbsent(e.startNode, new HashSet<>())
        adjList.putIfAbsent(e.endNode, new HashSet<>())

        adjList.get(e.startNode).add(e)
        adjList.get(e.endNode).add(e)

        return true
    }

    boolean addEdge(int nodeLabel1, int nodeLabel2) {
        return addEdge(new Edge(new Node(nodeLabel1, this).save(failOnError: true),
                new Node(nodeLabel2, this).save(failOnError: true), this).save(failOnError: true))
    }

    boolean removeEdge(Edge e) {
        if (!edges.remove(e)) return false
        Set<Edge> edgesOfV1 = adjList.get(e.startNode)
        Set<Edge> edgesOfV2 = adjList.get(e.endNode)

        if (edgesOfV1 != null) edgesOfV1.remove(e)
        if (edgesOfV2 != null) edgesOfV2.remove(e)

        return true
    }
/*
    boolean removeEdge(int nodeLabel1, int nodeLabel2) {
        return removeEdge(new Edge(new Node(nodeLabel1),
                new Node(nodeLabel2)))
    }*/

    Set<Node> getAdjVertices(Node v) {
        return adjList.get(v).stream()
                .map{e -> e.startNode.equals(v) ? e.endNode : e.startNode}
                .collect(Collectors.toSet())
    }

    Set<Node> getNodes() {
        return Collections.unmodifiableSet(nodes)
    }

    Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges)
    }

    Map<Node, Set<Edge>> getAdjList() {
        return Collections.unmodifiableMap(adjList)
    }


    Node getRoot() {
        if(this.nodes.isEmpty()){
            //println("nodos esta vacio")
            this.addNode(new Node(0,this).save(failOnError: true))
        }



        //return  this.nodes.stream().filter{node -> node.id == 0}.findFirst().get()
        /*def a = this.nodes.find {node -> node.nodeId == 0}
        println(a)
        return a*/
        def a = this.nodes.stream().filter{node -> node.nodeId == 0}.findFirst().get()
      //  println(a)
        return a

    }

    Set<Edge> getAdjacentsToNodeWithSpecificBodyPart(Node v, String bodyPartName){
        return this.edges.stream().filter{
            edge -> edge.startNode.id == v.id && edge.endNode.cloth.bodyPart.name() == bodyPartName}.collect()
    }

    def addCloth(Clothes cloth){
        Node root = this.getRoot()
        Edge newEdge

        Node newNode = new Node(this.nodes.size()+1, cloth, this)
        this.nodes.add(newNode)

        if(cloth.bodyPart.name() == "CHEST"){
            newEdge = new Edge(root,newNode, this)
            this.addEdge(newEdge)
            newEdge.save(failOnError: true)
        }
        if(cloth.bodyPart.name() == "CHEST2"){
            this.connectWithAll("CHEST", newNode)
        }
        if(cloth.bodyPart.name() == "CHEST3"){
            this.connectWithAll("CHEST2", newNode)
        }
        if(cloth.bodyPart.name() == "LEGS"){
            this.connectWithAll("CHEST", newNode)
        }
        if(cloth.bodyPart.name() == "FEETS"){
            this.connectWithAll("LEGS", newNode)
        }
        if(cloth.bodyPart.name() == "HANDS"){
            this.connectWithAll("CHEST3", newNode)
        }
        if(cloth.bodyPart.name() == "NECK"){
            this.connectWithAll("CHEST3", newNode)
        }
        if(cloth.bodyPart.name() == "HEAD"){
            this.connectWithAll("CHEST", newNode)
        }
        newNode.save(failOnError: true)
    }

    def connectWithAll(String bodyPart, Node endNode) {
        this.getNodes().stream().filter{ node -> node.cloth != null && node.cloth.bodyPart.name() == bodyPart}
                .forEach{ node -> this.addEdge(new Edge(node,endNode,this).save(failOnError: true)) }
    }

    def updateProbabilities(Edge edge, Set<Edge> edges) {
        int amount = edges.size()
        double percentage = 100 / (amount + 1)
        for(Edge edgy: edges){
            edgy.setProbability(edgy.probability * (1 - percentage/100))
        }
        edge.setProbability(percentage)
    }


    def useCombination(Node from, Node to) {
        Edge edge = this.getEdge(from.id,to.id)
        if(edge != null){
            edge.use()
        }
    }

    Edge getEdge(int startId, int endId) {
        Optional<Edge> optionalEdge = this.edges.stream().filter{ edge -> edge.startNode.id == startId && edge.endNode.id == endId}.findFirst()
        if(optionalEdge.isPresent()){
            return optionalEdge.get()
        }
        return null
    }

    List<Node> getSuggestion(int amountOfClothes){
        List<Node> nodes = new ArrayList<>()
        List<String> bodyParts = ["CHEST","LEGS","FEET","CHEST2","CHEST3","HANDS","NECK","HEAD"]
        Node actualNode = this.getRoot()
        Random rand = new Random()
        for(int i = 0 ; i < amountOfClothes ; i ++) {
            List<Edge> edges = this.getAdjacentsToNodeWithSpecificBodyPart(actualNode, bodyParts.get(i))
            if (!edges.isEmpty()) {
                double prediction = rand.nextFloat()
                Node chosenNode = this.getBestMatch(prediction, edges)
                actualNode = chosenNode
                nodes.add(chosenNode)
            }
        }
        return nodes
    }

    Node getBestMatch(double prediction, List<Edge> edges) {
        double accumulated = 0
        int totalEdgesWeight = edges.stream().mapToInt{edge -> edge.weight}.sum()
        for(Edge edge: edges){
            accumulated += (edge.weight/totalEdgesWeight)
            if(prediction < accumulated){
                return edge.endNode
            }
        }
    }
}
