package myCode.b_dataStructure.graph.unionFind.leetcode;

public class lc323final {

    public int countComponents(int n , int[][] edges){
        /**
         * 初始化: parent[]
         */
        int res = n ;
        int[] parents = new int[n] ;
        for (int i = 0; i <parents.length; i++){
            parents[i]=i;
        }
        /**
         *进行union操作，int[][]edges，pair是int[]数组
         */
        for(int[] pair : edges) {
            int x = find (parents, pair[0]);
            int y = find (parents, pair[1]);
            if (x != y ){
                parents[x] = y;
                res--;//融合一次少一个，
            }
        }
        return res;
    }

    private int find (int[] parents, int index){
        while (index != parents[index]){
            parents[index] = parents[parents[index]];//路径压缩
            index = parents[index];
        }
        return index;
    }

    //优先
    public int find2 (int[] parents, int index) {
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }
}
