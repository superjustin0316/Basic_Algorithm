package myCode.b_dataStructure.graph.shortestPath.bellmanFord;

import java.util.Arrays;

public class BellmanFord {

    public void bellmanFord(Graph graph) {

        /**
         * 初始化：
         * minDist[index]（从起点到终点index的距离）
         * graph[顶点，从该顶点出发的边]
         */
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;//设置起点

        for (int i = 1; i < graph.vertices; i++) {//遍历n-1次,每个点进行松弛操作，滚动更新
            for (int j = 0; j < graph.allEdges.size(); j++) {
                Edge edge = graph.allEdges.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                    minDist[end] = minDist[start] + weight;
                }
            }
        }

        for (int j = 0; j < graph.allEdges.size(); j++) {
            Edge edge = graph.allEdges.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                System.out.println("负权环");
                //相当于进行第n次遍历，如果继续出现松弛操作，则说明存在负权环
            }
        }
        print(minDist);
    }

    public void print(int[] minDist) {
        System.out.println("BellmanFord shortestPath : ");
        for (int i = 0; i < minDist.length; i++) {
            System.out.println("Vertex (0) -> Vertex ("+i+")    MinDist:"+minDist[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,2);
        graph.addEdge(2,3,4);
        graph.addEdge(2,4,3);
        graph.addEdge(3,4,2);
        graph.addEdge(3,5,1);
        graph.addEdge(4,5,6);

        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.bellmanFord(graph);
    }
}