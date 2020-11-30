package myCode.b_dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    int label;
    List<GraphNode> neighbors;

    GraphNode(int label){
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
