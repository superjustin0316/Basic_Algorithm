package myCode.b_dataStructure.graph.minimumSpanTree.kruskal;

import myCode.b_dataStructure.graph.unionFind.IUnionFind;

public class PathCompressionImpl implements IUnionFind {
    int count;
    private int[] id;

    public PathCompressionImpl(int count) {
        this.count = count ;
        id = new int[count];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }//给定count的值

    @Override
    public void union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (A == B) { return; }// 如果A,B属于两个集合，就直接结束本程序
        for (int i = 0 ; i < id.length; i++){
            if (id[i] == A) {
                id[i] = B ;//把所有属于set A的元素值全部更新为set B的值-->融合
            }
        }
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count){
            System.out.println("越界");
        }
        return id[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x)== find(y);
    }
}

//    int count;
//    private int[] parents;
//    private int[] size;
//    //  private int[] rank;
//    public PathCompressionImpl(int count) {
//        this.count = count ;
//        parents = new int[count];
//        this.size = new int[count];
//
//        for (int i = 0; i < parents.length; i++) {
//            parents[i] = i;
//            size[i] = 1;
////            rank[i] = 1;
//        }
//    }
//
//    @Override
//    public int count() {
//        return count;
//    }//给定count的值
//
//    @Override
//    public void union(int x, int y) {
//        int xRoot = find(x);
//        int yRoot = find(y);
//        if (xRoot == yRoot) { return; }// 直接结束本程序
////        if (rank[xRoot] < rank[yRoot]){
////            parents[xRoot] = yRoot;
////        } else if (rank[yRoot] < rank[xRoot]){
////            parents[yRoot] = xRoot;
////        }else {
////            parents[yRoot] = xRoot;
////            rank[xRoot]++;
////        }
//        if ( size[xRoot] < size[yRoot] ){
//            parents[xRoot] = yRoot;
//            size[yRoot] += size[xRoot];
//        } else {
//            parents[yRoot] = xRoot;
//            size[xRoot] += size[yRoot];
//        }
//    }
//
//    @Override
//    public int find(int index) {
//        if (index < 0 || index >= count){
//            System.out.println("越界");
//        }
//        while (index != parents[index]) {
//            parents[index] = parents[parents[index]];//路径压缩1
//            index = parents[index];//向上追溯到parent.root
//        }
//        return index;
//    }
//    //强制使树变成两层
//    public int find2(int index) {
//        if (index < 0 || index >= count){
//            System.out.println("越界");
//        }
//        if (index != parents[index]) {
//            parents[index] = find(parents[index]);
//        }
//        return parents[index];
//    }
//
//    @Override
//    public boolean connected(int x, int y) {
//        return find(x)== find(y);
//    }
//}
