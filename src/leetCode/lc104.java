package leetCode;

import myCode.b_dataStructure.tree.traversal.TreeNode;

public class lc104 {
    public static int maxDepth(TreeNode root){
        if (root == null)   return 0;

        int l = maxDepth(root.left)+1;
        int r = maxDepth(root.right)+1;

        return Math.max(l,r);
    }
}
