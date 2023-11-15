//Makaluza
//Imonge
//4008241
//CSC212 2022 Practical 4 Term 1
//Question2.java

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    int vertices;
    int[][] adjacencyMatrix = new int[17][3];
    int Edges;
    List<String> nodelist = new ArrayList<String>();
    Map<String, Integer> indexOfVertices = new HashMap<>(); //assign Node values integer indexes

    public void addEdge(String from, String to, int weight){
        if (!nodelist.contains(from)){
            nodelist.add(from);
            indexOfVertices.put(from,vertices);
            vertices++;
        }
        if (!nodelist.contains(to)) {
            nodelist.add(to);
            indexOfVertices.put(to, vertices);
            vertices++;
        }

        adjacencyMatrix[Edges][0] = indexOfVertices.get(from);
        adjacencyMatrix[Edges][1] = indexOfVertices.get(to);
        adjacencyMatrix[Edges][2] = weight;
        Edges++;
    }
    public void shortestDistance(int graph[][], int V, int E,
                                 String src) {

        // Initialize distance of all vertices as infinite.
        int[] distance = new int[V];
        for (int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;

        // initialize distance of source as 0
        distance[indexOfVertices.get(src)] = 0;

        //BellmanFord algorithm
        for (int x = 0; x < V - 1; x++) {
            for (int y = 0; y < E; y++) {
                if (distance[graph[y][0]] != Integer.MAX_VALUE && distance[graph[y][0]] + graph[y][2] < distance[graph[y][1]])
                    distance[graph[y][1]] = distance[graph[y][0]] + graph[y][2];
            }
        }

        // check for negative-weight cycles.
        for (int i = 0; i < E; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            int weight = graph[i][2];
            if (distance[x] != Integer.MAX_VALUE && distance[x] + weight < distance[y])
                System.out.println("Graph contains negative weighted cycles");
        }
    }
}