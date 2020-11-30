package myCode.b_dataStructure.graph.minimumSpanTree.prim;

import javafx.util.Pair;

import java.util.*;

public class Prim {

    public void primMST(Graph graph){
        /**
         * 初始化 ：
         * visited[] 是否作为起点访问过，初始为false
         * minDists[] 记录到达当前节点的最小距离
         * parentsStart[] 起点，初始为-1
         */
        boolean[] visited = new boolean[graph.vertices];
        int[] minDists = new int[graph.vertices];
        int[] parentsStart = new int[graph.vertices];

        Arrays.fill(minDists, Integer.MAX_VALUE);
        Arrays.fill(parentsStart,-1);
        /**
         * Pair:[key: weight, value: vertex]
         */
        PriorityQueue<Pair<Integer,Integer>> pq =
                new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        int key1 = o1.getKey();
                        int key2 = o2.getKey();
                        return key1-key2;
                    }
                });

        minDists[0] = 0;
        pq.offer(new Pair<>(minDists[0], 0));
        while (!pq.isEmpty()){
            Pair< Integer, Integer > pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true ;
            List<Edge> list = graph.list[vertex];//获取graph中与当前的vertex连接的顶点list
            for (int i = 0; i <list.size(); i++){
                Edge edge = list.get(i);
                if ( !visited[edge.end] ){//判断是否访问过
                    int destination = edge.end;
                    int curDist = edge.weight;
                    if (curDist < minDists[destination]) {   //小于最小的距离
                        pq.offer(new Pair<>(curDist,destination));
                        parentsStart[destination] = vertex;  //更新parentsStart为起点
                        minDists[destination] = curDist;     //更新minDist
                    }
                }
            }
        }
        print(parentsStart,minDists,graph.vertices);
    }

    public void print(int[] parentsStart, int[] minDists, int vertices){
        int total = 0;
        System.out.println("MST: ");
        for(int i = 1; i < parentsStart.length; i++ ){
            System.out.println("Edge : "+i +" - "+ parentsStart[i] + " minDist : " + minDists[i]);
            total +=minDists[i];
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
