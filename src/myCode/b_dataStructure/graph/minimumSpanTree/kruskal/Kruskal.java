package myCode.b_dataStructure.graph.minimumSpanTree.kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    public void kruskalMST(Graph graph){
        /**
         * 初始化：
         * pq[所有的边（起点，终点）]
         * list<Edge> res:加入所有边
         */
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> (a.weight - b.weight)); //???
        pq.addAll(graph.allEdges);

        List<Edge> res = new ArrayList<>();
        PathCompressionImpl unionFind = new PathCompressionImpl(graph.vertices);
        int components =  graph.vertices;

        while (!pq.isEmpty()){
            if (components <= 1){//此时已经进行n-1次循环
                break;//  进行n-1次结束循环，1，2，3..,vertices
            }
            Edge edge = pq.poll();
            if (unionFind.connected(edge.start, edge.end)){//  判断是否有环,
                // 如果有，则continue跳出当下循环，继续下面的循环
                continue;
            }
            unionFind.union(edge.start, edge.end);
            components--;
            res.add(edge);
        }
        print(res);
    }

    public void print(List<Edge> list){
        int total = 0;
        System.out.println("MST: ");
        for(int i = 0; i < list.size(); i++ ){
            System.out.println("Edge : "+list.get(i).start +" - "+ list.get(i).end + " weight : " + list.get(i).weight);
            total +=list.get(i).weight;
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

        Kruskal kruskal = new Kruskal();
        kruskal.kruskalMST(graph);


    }
}
