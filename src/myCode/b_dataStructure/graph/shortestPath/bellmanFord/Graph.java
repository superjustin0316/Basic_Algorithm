package myCode.b_dataStructure.graph.shortestPath.bellmanFord;

import java.util.ArrayList;

public class Graph {
    /**
     *graph：edgeList
     */

    int vertices;

    ArrayList<Edge> allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        allEdges = new ArrayList<>();
    }

    public void addEdge(int start, int end ,int weight) {
        Edge edge = new Edge(start, end , weight);//有向图，有起止点
        allEdges.add(edge);
    }
}
