/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return backtrack(root,subRoot);

    }
    public static boolean backtrack(TreeNode root ,TreeNode subRoot){
        if(root != null){
            if(equalTrees(root,subRoot)) return true;

                return( backtrack(root.left ,subRoot) ||
                        backtrack(root.right ,subRoot));

        }else
            return false;
    }

    public static boolean equalTrees(TreeNode tree1,TreeNode tree2){
        if(tree1 == null && tree2==null) return true;
        if(tree1 ==  null || tree2 ==null || tree1.val != tree2.val) return false;
        return (equalTrees(tree1.left,tree2.left) && equalTrees(tree1.right,tree2.right));
    }
}