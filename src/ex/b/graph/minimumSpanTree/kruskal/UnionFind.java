package ex.b.graph.minimumSpanTree.kruskal;

public class UnionFind {

    public int[] id;
    public int count;

    public UnionFind(int count) {
        this.count = count;
        this.id = new int[count];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int x, int y) {
        return (find(x) == find(y));
    }

    public int find(int index){
        if (index < 0 || index >= count){
            System.out.println("越界");
        }
        return id[index];
    }


    public void union(int x, int y) {
        int A = id[x];
        int B = id[y];
        if (A == B){return;}
        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }
    }
}