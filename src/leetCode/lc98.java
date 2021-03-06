package leetCode;

import myCode.b_dataStructure.tree.traversal.TreeNode;

public class lc98 {
    private static boolean isValidBST(TreeNode root){
        if (root == null ) return true;
        return helper(root, null, null);
    }
    public  static  boolean helper(TreeNode root, Integer min, Integer max){
        if (root == null ) return true;
        if (min != null && root.val <= min)   return false;
        if (max != null && root.val >= max )  return false;
        return helper(root.left, min , root.val) && helper(root.right,root.val, max);
    }
}
