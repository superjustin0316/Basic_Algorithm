package myCode.b_dataStructure.graph.unionFind;

public interface IUnionFind {

    int count();

    void union(int x, int y);//节点进行融合

    int find (int index);//找到对应的集合

    boolean connected(int x, int y);//判断是否两个点是属于同一集合

}
