package ex.b.graph.topo;

import java.util.*;

public class Topo {

    public int[] bfstopo_finder(int numCourses, int[][] prerequisites){

        int k = 0;
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){
            indegree[pair[0]]++;//在终点处计算入度
        }

        //起始步
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()){
            int pre = queue.poll();
            for( int[] pair : prerequisites ){
                if (pair[1] == pre) {
                    indegree[pair[0]]-- ;
                    if (indegree[pair[0]] == 0){
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];
    }

    public int[] dfstopo_finder(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pair : prerequisites){
            int prev = pair[1];//[next;prev]
            int next = pair[0];
            graph.get(prev).add(next);
        }

        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            visited.put(i,0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0) {
                if (!helper(graph, visited, res, i)){
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(numCourses-i-1);
        }
        return result;
    }

    private boolean helper(List<List<Integer>> graph, HashMap<Integer,Integer> visited,
                           List<Integer> res, int i){
        if (visited.get(i) == 2){
            return true;
        }
        if (visited.get(i) == 1) {
            return false;
        }

        visited.put(i,1);
        for (int j : graph.get(i)) {
            if (!helper(graph,visited,res,i)){
                return false;
            }
        }
        visited.put(i,2);
        res.add(i);
        return true;

    }
}
