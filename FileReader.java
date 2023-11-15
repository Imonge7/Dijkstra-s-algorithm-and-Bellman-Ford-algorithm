//Makaluza
//Imonge
//4008241
//CSC212 2022 Practical 4 Term 1
//Question2.java

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public Graph readfile(String location){
        Graph graph = new Graph();
        try {
            File file = new File(location);
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String arr[] = line.split(";");

                for (int x = 1; x < arr.length; x = x + 2) {
                    graph.addEdge(arr[0], arr[x], Integer.parseInt(arr[x + 1]));
                }
            }

        } catch (FileNotFoundException f) {
            System.out.println("File not found");
            System.exit(0);
        }
        return graph;
    }
}
