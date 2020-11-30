package myCode.b_dataStructure.graph.unionFind.impl;

import myCode.b_dataStructure.graph.unionFind.IUnionFind;

public class QuickFindImpl implements IUnionFind {

    int count;
    private int[] id;

    public QuickFindImpl(int count) {
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
