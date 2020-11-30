package ex.b.graph.minimumSpanTree.kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    public void kruskalMST(Graph graph) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.addAll(graph.allEdges);

        List<Edge> res = new ArrayList<>();
        UnionFind unionFind = new UnionFind(graph.vertices);
        int remainComponents = graph.vertices;

        while (!pq.isEmpty()) {
            if (remainComponents <= 1) {//此时已进行了 n-1 次循环
                break;
            }
            Edge edge = pq.poll();
            if (unionFind.connected(edge.start, edge.end)) {//?
                continue;
            }
            unionFind.union(edge.start, edge.end);
            remainComponents--;
            res.add(edge);
        }
        int total = 0;
        for (int i = 0; i < res.size(); i++) {
            System.out.println("Edge: start:" + res.get(i).start + " --> end:" + res.get(i).end);
            total += res.get(i).weight;
        }
        System.out.println("Total: " + total);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);

        Kruskal kruskal = new Kruskal();
        kruskal.kruskalMST(graph);
    }
}


