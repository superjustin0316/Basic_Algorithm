package myCode.b_dataStructure.graph.shortestPath.dijkstra;

public class Edge {

    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}