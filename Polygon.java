package Polygon;
public class Polygon{
    protected int edges;
    private String poly_name;
    void printEdges(){
        System.out.print("Number of edges: " + edges);
    }
    public void printInfo(){
        System.out.println("Number of edges: " + edges + "Name of Polygon: " + poly_name);
    }
}