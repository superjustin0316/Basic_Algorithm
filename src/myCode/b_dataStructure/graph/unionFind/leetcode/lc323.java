package myCode.b_dataStructure.graph.unionFind.leetcode;

public class lc323 {
    public class quickFind{
        int res;//全局变量

        int count;
        private int[] id;

        public void union(int x, int y) {
            int A = find(x);
            int B = find(y);
            if (A == B) {
                return;
            }// 直接结束本程序
            for (int i = 0 ; i < id.length; i++){
                if (id[i] == A) {
                    id[i] = B ;//把所有属于set A的元素值全部更新为set B的值-->融合
                }
            }
            res -- ;
        }

        public int find(int index) {
            if (index < 0 || index >= count){
                System.out.println("越界");
            }
            return id[index];
        }

        public boolean connected(int x, int y) {
            return find(x)== find(y);
        }

        public int countComponents(int n , int[][] edges){
            res = n ;
            this.count = n;
            id = new int[count];

            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }

            for (int[] pair:edges) {
                int A = find(pair[0]);
                int B = find(pair[1]);
                union(A,B);
            }
            return  res;
        }
    }

    public class quickUnion{
        int res;//全局变量
        int count;
        private int[] parents;

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) { return; }// 直接结束本程序
            parents[xRoot] = yRoot;
            res--;
        }

        public int find(int index) {
            if (index < 0 || index >= count){
                System.out.println("越界");
            }
            while (index != parents[index]) {
                index = parents[index];//向上追溯到parent.root
            }
            return index;
        }

        public boolean connected(int x, int y) {
            return find(x)== find(y);
        }

        public int countComponents(int n , int[][] edges){
            res = n ;
            this.count = n;
            parents = new int[count];

            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            for (int[] pair:edges) {
                int xRoot = find(pair[0]);
                int yRoot = find(pair[1]);
                union(xRoot,yRoot);
            }
            return  res;
        }
    }


}
