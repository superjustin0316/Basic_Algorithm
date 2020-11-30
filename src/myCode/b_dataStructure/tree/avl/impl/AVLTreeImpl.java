package myCode.b_dataStructure.tree.avl.impl;

import myCode.b_dataStructure.tree.avl.AVLNode;
import myCode.b_dataStructure.tree.avl.IAVLTree;


import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeImpl implements IAVLTree {

    public AVLNode root;
    int size;
    public AVLTreeImpl(){
        this.root = null;
        this.size=0;
    }

    @Override
    public void add(int val) {
        root = add(root,val);//????
    }

    private AVLNode add(AVLNode node, int val){
        if(node == null) {
            size++;
            return new AVLNode(val);//为上面的递归做准备
        }
        if(node.val == val){
            System.out.println("节点已存在");
        }
        if(node.val > val){
            node.left = add(node.left,val);
        }else {
            node.right = add(node.right,val);
        }

        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));//???

        //加入平衡因子
        int balanceFactor = getBalanceFactor(node);

        /**
         * 调整AVL树
         */
        //LL:
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }
        //RR:
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        return node;
    }

    private AVLNode rightRotate(AVLNode x){
        AVLNode y = x.left;
        AVLNode c = y.right;

        y.right = x;
        x.left = c;

        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;

        return y;
    }

    private AVLNode leftRotate(AVLNode x){
        AVLNode y = x.right;
        AVLNode c = y.left;

        y.left = x;
        x.right = c;

        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;

        return y;
    }

    private int getBalanceFactor(AVLNode node){
        return node== null ? 0: getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(AVLNode node){
        return node == null ? 0 : node.height;
    }

    private boolean isBST(AVLNode node){
        if (node == null ) return true;
        return helper(node, null, null);
    }

    private boolean helper(AVLNode root, Integer min, Integer max){
        if (root == null ) return true;
        if (min != null && root.val <= min)   return false;
        if (max != null && root.val >= max )  return false;
        return helper(root.left, min , root.val) && helper(root.right,root.val, max);
    }

    private boolean isBalanced(AVLNode node){
            if (node == null ) return true;
            return helper(node)!= -1;
    }

    private int helper(AVLNode root){
        if (root == null)  return 0;
        int l = helper(root.left)+1;
        int r = helper(root.right)+1;
        if (l == -1 || r == -1 || Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r)+1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private void print(){
        int level = 0;
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println("第"+(level+1)+"层：  ");
            for(int i = 0 ; i < size ; i++){
                AVLNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null){
                    System.out.println("left side："+cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    System.out.println("right side："+cur.right.val);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        AVLTreeImpl avlTree = new AVLTreeImpl();
        avlTree.add(8);
        avlTree.add(5);
        avlTree.add(6);
        avlTree.add(3);
        avlTree.add(10);
        avlTree.add(9);
        avlTree.add(11);
        avlTree.add(2);
        avlTree.add(4);
        avlTree.print();
        System.out.println("isBST: "+avlTree.isBST(avlTree.root));
        System.out.println("isBalanced: "+avlTree.isBalanced(avlTree.root));
    }
}
