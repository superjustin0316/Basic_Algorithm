package myCode.b_dataStructure.tree.binarySearchTree.impl;

import myCode.b_dataStructure.tree.binarySearchTree.IBinarySearchTree;
import myCode.b_dataStructure.tree.binarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl implements IBinarySearchTree {
    private TreeNode root;
    private int size;
    public BinarySearchTreeImpl(){
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root,val);
    }

    private TreeNode add (TreeNode node, int val){
        if(node == null) {
            size++;
            return new TreeNode(val);
        }
        if(node.val == val)     System.out.println("节点已存在");
        if(node.val > val){     node.left = add(node.left,val);
        }else {                 node.right = add(node.right,val); }
        return node;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private TreeNode remove(TreeNode node, int val){

        if (node == null){
            return null;//判定条件
        }
        //定位node
        if (node.val > val){          node.left = remove(node.left, val);}//递归环节
        else if (node.val < val) {    node.right = remove(node.right, val);}//递归环节
        else{//判定条件
            if (node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            }

            TreeNode minNode = findMin(node.right);
            node.val = minNode.val;//在删除节点的位置处赋右子树中的最小值
            node.right = remove(node.right,node.val);//删除右子树中的最小值
        }
        return node;
    }

    private  TreeNode findMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(int val) {
        return contains(root,val);
    }
    private boolean contains(TreeNode node,int val){
        if (node == null){
            return false;//判定条件1
        }
        if (node.val ==val){
            return true;//判定条件2
        }else if (node.val > val){
            return contains(node.left, val);
        }else {
            return contains(node.right,val);
        }

    }

    private void print(){
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println("第"+(level+1)+"层：  ");
            for(int i = 0 ; i < size ; i++){
                TreeNode cur = queue.poll();
                System.out.println(cur.val);
                if (cur.left != null){
                    System.out.println("left side："+cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    System.out.println("right side："+cur.right.val);
                    queue.offer(cur.right);
                }
                if (cur.right == null && cur.left == null){
                    System.out.println("left side： null");
                    System.out.println("right side： null");
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.add(8);
        binarySearchTree.add(5);
        binarySearchTree.add(6);
        binarySearchTree.add(3);
        binarySearchTree.add(10);
        binarySearchTree.add(9);
        binarySearchTree.add(11);

        binarySearchTree.print();
        binarySearchTree.remove(8);
        System.out.println(binarySearchTree.contains(6));
    }
}
