//Makaluza
//Imonge
//4008241
//CSC212 2022 Practical 4 Term 1
//Question1.java

public class Question1 {
        public static void main(String[] args){
            FileReader reader = new FileReader();
            Graph graph = reader.FileReader("C:/Users/Lordm/Downloads/airline-network.txt");
            System.out.println(graph.getShortestDistance("HLA","CPT"));
        }
}
