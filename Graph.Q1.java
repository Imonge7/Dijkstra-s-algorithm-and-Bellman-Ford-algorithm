//Makaluza
//Imonge
//4008241
//CSC212 2022 Practical 4 Term 1
//Question1.java

import java.util.*;

class Graph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }
        public List<Edge> getEdges() {
            return edges;
        }
    }
    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    private Map<String,Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label,new Node(label));

    }
    public void addEdge(String from, String to, int weight) {
        if (nodes.containsKey(from) == false);
            addNode(from);

        if (nodes.containsKey(to) == false);
        addNode(to);

        var fromNode = nodes.get(from);
        nodes.containsKey(from);

        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode  = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }
    //class to store node priority which is distance
    private  class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
    public int getShortestDistance(String from,String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        Map<Node, Integer> distances = new HashMap<>();


        // Initialize distance of all vertices as infinite.
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);

        // initialize distance of source as 0
        distances.replace(fromNode,0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne-> ne.priority));
        queue.add(new NodeEntry(fromNode, 0));

        // Dijkstra's Algorithm
       while (!queue.isEmpty()) {
           var current = queue.remove().node;
           visited.add(current);

           for (var edge : current.getEdges()){
               if (visited.contains(edge.to))
                   continue;

               var newDistance = distances.get(current) + edge.weight;
               if (newDistance < distances.get(edge.to)){
                   distances.replace(edge.to,newDistance);
               }
           }
       }
        return distances.get(nodes.get(to));
    }
}
