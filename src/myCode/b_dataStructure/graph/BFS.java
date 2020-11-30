package myCode.b_dataStructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    public static void bfs1(GraphNode graphNode){
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);
        
        while (!queue.isEmpty()){
            GraphNode node = queue.poll();
            System.out.print("->"+node.label);
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void bfs2(GraphNode graphNode){
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            int size = queue.size();//加入回合数
            for (int i = 0; i < size; i++) {
                GraphNode node = queue.poll();
                System.out.println   ( node.label+"->" );
                for (GraphNode neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println("--------");
        }
    }

    //??
    public static void bfsIteration(GraphNode graphNode){
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();

        stack.push(graphNode);
        visited.add(graphNode);

        while (!stack.isEmpty()){
            GraphNode node = stack.pop();
            System.out.println("->"+node.label);
            for (GraphNode neighbor : node.neighbors){
                if (!visited.contains(neighbor)){
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void bfsMatrixIteration(int[][] matrix){//???
        int[] visited = new int [matrix.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0){
                visited[i] = 1 ;
                queue.offer(i);
                while (!queue.isEmpty()){
                    int size = queue.size();// 插入回合次数
                    for (int k = 0; k < size; k++) {
                        Integer vertex = queue.poll();
                        System.out.println(vertex);
                        for(int j=0;j<matrix.length;j++){
                            if(matrix[vertex][j] ==1){
                                if (visited[j] == 0){
                                    queue.offer(j);
                                    visited[j] = 1;
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b); a.neighbors.add(d); a.neighbors.add(f);

        b.neighbors.add(a); b.neighbors.add(e); b.neighbors.add(c);

        c.neighbors.add(b); c.neighbors.add(e);

        d.neighbors.add(a); d.neighbors.add(e);

        e.neighbors.add(d); e.neighbors.add(b); e.neighbors.add(c);

        f.neighbors.add(a);

        int[][] matrix =new int[][] {
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0}
        };

        bfs2(a);
    }
}
