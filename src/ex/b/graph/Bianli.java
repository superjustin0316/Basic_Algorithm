package ex.b.graph;


import java.util.*;

public class Bianli {
    public static LinkedHashSet bfs_queue(GraphNode startNode){
        LinkedHashSet<Integer> visited = new LinkedHashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(startNode.label);
        queue.offer(startNode);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = queue.poll();
                System.out.println(node.label);
                for(GraphNode neighbor: node.neighbors){
                    if(!visited.contains(neighbor.label)){
                        queue.offer(neighbor);
                        visited.add(neighbor.label);
                    }
                }
            }
            System.out.println();
        }
        return visited;
    }

    public static HashSet dfs_stack(GraphNode startNode){
        HashSet<GraphNode> visited = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();

        visited.add(startNode);
        stack.push(startNode);

        while (!stack.isEmpty()){
            GraphNode node = stack.pop();
            for(GraphNode neighbor : node.neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return visited;
    }

    public static void bfsMatrixIteration(int[][] matrix){
        int[] visited = new int [matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        LinkedHashSet<Integer> visitedset = new LinkedHashSet<>();

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0){
                visited[i] = 1 ;
                queue.offer(i);
                while (!queue.isEmpty()){
                    //int size = queue.size();// 插入回合次数
                    //for (int k = 0; k < size; k++) {
                        int vertex = queue.poll();
                        visitedset.add(vertex);
                        //System.out.println(vertex);
                        for(int j=0;j<matrix.length;j++){
                            if(matrix[vertex][j] ==1){
                                if (visited[j] == 0){
                                    queue.offer(j);
                                    visited[j] = 1;
                                }
                            }
                        //}
                    }
                    System.out.println();
                }
            }
        }
        System.out.println(visitedset);
    }

    public static LinkedHashSet dfsMatrixIteration(int[][] matrix){
        int[] visited = new int [matrix.length];
        Stack<Integer> stack = new Stack<>();
        LinkedHashSet<Integer> visitedset = new LinkedHashSet<>();


        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        for(int i = 0; i < matrix.length ; i++) {
            if(visited[i] == 0){
                visited[i] = 1;
                stack.push(i);
                while (!stack.isEmpty()){
                    int vertex = stack.pop();
                    visitedset.add(vertex);
                    for (int j = 0; j < matrix.length; j++) {
                        if(matrix[vertex][j] == 1) {
                            if(visited[j] == 0) {
                                helper(matrix,visited,j,visitedset);
                            }
                        }
                    }
                }
            }
        }
        return visitedset;
    }

    public static void helper(int[][] matrix, int[] visited, int vertex, LinkedHashSet visitedset){
        visited[vertex] =1;
        visitedset.add(vertex);

        for(int i= 0 ; i < matrix.length; i++){
            if(matrix[vertex][i] == i ){
                if(visited[i] == 0) {
                    helper(matrix,visited,i,visitedset);
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

        int[][] matrix1 =new int[][] {
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0}
        };
        System.out.println(dfsMatrixIteration(matrix1));
//        bfsMatrixIteration(matrix1);

//        LinkedHashSet<GraphNode> visited = new LinkedHashSet<>();
//        visited = bfs_queue(a);
//        //1
//        System.out.print(visited);//默认调用toString
//        System.out.println("\n----------------------");
//        //2、
//        for (Object object : visited) {
//            System.out.print(object);
//        }
//        System.out.println("\n----------------------");
//        //3、
//        Iterator i = visited.iterator();
//        while(i.hasNext()){
//            System.out.print(i.next());
//        }
//        System.out.println("\n----------------------");

//        int[] visitedArrayList = new int [matrix1.length];
//        visitedArrayList = bfsMatrixIteration(matrix1);
//        System.out.println(visitedArrayList.length);

//        for (int m = 0; m < matrix1.length; m++) {
//            System.out.println(visitedArrayList[m]);
//        }

    }

}
