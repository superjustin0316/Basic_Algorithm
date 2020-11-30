package myCode.b_dataStructure.graph.unionFind.impl;

import myCode.b_dataStructure.graph.unionFind.IUnionFind;

public class QuickUnionImpl implements IUnionFind {
    int count;
    private int[] parentNode;

    public QuickUnionImpl(int count) {
        this.count = count ;
        parentNode = new int[count];

        for (int i = 0; i < parentNode.length; i++) {
            parentNode[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }//给定count的值

    @Override
    public void union(int x, int y) {//两个节点进行融合
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) { return; }// 如果属于相同集合，就结束本程序
        parentNode[xRoot] = yRoot;
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count){
            System.out.println("越界");
        }
        while (index != parentNode[index]) {
            index = parentNode[index];//向上追溯到parent.root
        }
        return index;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x)== find(y);
    }
}
