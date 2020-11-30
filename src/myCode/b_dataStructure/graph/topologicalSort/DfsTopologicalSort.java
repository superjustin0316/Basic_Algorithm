package myCode.b_dataStructure.graph.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DfsTopologicalSort {

    public int[] findOrder(int numCourses, int[][] prerequisites){
        /**
         * 预处理
         */
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] pair: prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);//list< list<Integer>:prev -> next >
        }

        /**
         * DFS
         * 0:unvisited, 1:visiting, 2:visited
         */
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            visited.put(i,0);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            if (visited.get(i) == 0) {
                if (!helper(graph, visited,res,i)){//判断是不是环
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        for(int i = 0; i< result.length;i++ ){
            result[i] = res.get(numCourses-i-1);
        }
        return result;//倒序存储
    }

    private boolean helper(List<List<Integer>> graph, HashMap<Integer, Integer> visited,
                           List<Integer> res, int i){
        if (visited.get(i) == 2) {
            return true;
        }
        if (visited.get(i) == 1) {
            return false;
        }
        //该节点为unvisited
        visited.put(i,1);
        for (int j :graph.get(i)) {//遍历每门课的neighbor
            if (!helper(graph, visited,res,i)){
                return false;
            }
        }
        visited.put(i,2);
        res.add(i);
        return true;
    }
}
