package ex.b.graph.union;

public class unionFind {
    int count;
    private int[] id;

    public unionFind(int count){
        this.count = count;
        id  = new int[count];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public  void union(int x, int y) {// A归为B
        int A = find(x);
        int B = find(y);
        if (A==B){ return;}
        for(int i = 0; i < id.length; i++){
            if (id[i] == A){
                id[i] = B;
            }
        }
    }

    public int find(int index){
        if (index < 0 || index >= count){
            System.out.println("越界");
        }
        return id[index];
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
