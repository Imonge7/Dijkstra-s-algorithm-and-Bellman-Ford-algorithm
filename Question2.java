//Makaluza
//Imonge
//4008241
//CSC212 2022 Practical 4 Term 1
//Question2.java

package com.company;

public class Question2 {
    public static void main(String[] args) {
            FileReader readFile = new FileReader();
            var graph = readFile.readfile("C:/Users/Lordm/Downloads/household-deliveries.txt");
            graph.shortestDistance(graph.adjacencyMatrix, 9, 17, "A");
        }
}
