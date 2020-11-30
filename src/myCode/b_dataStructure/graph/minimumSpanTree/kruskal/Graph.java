package myCode.b_dataStructure.graph.minimumSpanTree.kruskal;

import java.util.ArrayList;

public class Graph {

    int vertices;
    ArrayList<Edge> allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        allEdges = new ArrayList<>();
    }

    public void addEdge(int start, int end ,int weight) {
        Edge edge = new Edge(start, end , weight);//有向图
        allEdges.add(edge);
    }
}
