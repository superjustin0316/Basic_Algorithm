package ex.b.graph.minimumSpanTree.prim;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    public void primMST(Graph graph){

        boolean[] visited = new boolean[graph.vertices];
        int[] minWeight = new int[graph.vertices];
        int[] parentsStart = new int[graph.vertices];

        Arrays.fill(minWeight,Integer.MAX_VALUE);
        Arrays.fill(parentsStart,-1);
        minWeight[0] = 0;

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();//?
                int key2 = o2.getKey();
                return key1-key2;
            }
        });
        pq.offer(new Pair<>(minWeight[0],0));

        while ( !pq.isEmpty()){
            Pair< Integer , Integer > pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];//一维list
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if ( !visited[edge.end] ){
                    int destination = edge.end;
                    int curWeight = edge.weight;
                    if (curWeight < minWeight[destination]){
                        pq.offer(new Pair<>(curWeight,destination));
                        parentsStart[destination] = vertex;
                        minWeight[destination] = curWeight;
                    }
                }
            }
        }
        myPrint(parentsStart,minWeight,graph.vertices);
    }

    public void myPrint(int[] parentsStart, int[] minWeights, int vertices){
        int total = 0;
        for (int i = 1; i < vertices; i++) {
            System.out.println("StartNode: "+ i+"-> EndeNode: "+parentsStart[i]+"(minWeight"+minWeights[i]+")");
            total+=minWeights[i];
        }
        System.out.println("Total : "+total);
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1,6);
        graph.addEdge(0,2,1);
        graph.addEdge(0,3,5);
        graph.addEdge(1,2,5);
        graph.addEdge(1,4,3);
        graph.addEdge(2,4,6);
        graph.addEdge(2,3,5);
        graph.addEdge(2,5,4);
        graph.addEdge(3,5,2);
        graph.addEdge(4,5,6);
        Prim prim = new Prim();
        prim.primMST(graph);
    }
}

