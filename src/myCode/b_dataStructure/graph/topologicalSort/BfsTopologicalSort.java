package myCode.b_dataStructure.graph.topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTopologicalSort {

    public int[] finderes(int numCourses, int[][] prerequisites) {

        /**
         * 初始化+计算入度
         */
        int k = 0;
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites){ // pair: 0-next, 1-pre, pair[0]<-pair[1]
            indegree[pair[0]]++ ; //pair 枚举类，在迭代的时候发生变化
        }

        /**
         * 将入度为0的点，加入到queue中去
         */
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        /**
         * 如果起点是之前入度为0的点，则该路径终点的入度-1
         * 重新扫描，加入queue中/加入res[]中
         */
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for(int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]-- ;       //入度--
                    if (indegree[pair[0]] == 0){
                        queue.offer(pair[0]);
                        res[k++] = pair[0];     //更新入度
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];//当k不等于numCourse -> 有环
    }
}
