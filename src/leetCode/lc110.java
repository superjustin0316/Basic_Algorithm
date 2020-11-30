package leetCode;


import myCode.b_dataStructure.tree.binarySearchTree.TreeNode;

public class lc110 {
    public boolean isBalanced(TreeNode root){
        if (root == null ) return true;
        return helper(root)!= -1;
    }

    public int helper(TreeNode root){
        if (root == null)  return 0;
        int l = helper(root.left)+1;
        int r = helper(root.right)+1;
        if (l == -1 || r == -1 || Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
}
