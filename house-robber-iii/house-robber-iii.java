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
    public int rob(TreeNode root) {
        int[] path = dfs(root);
        return Math.max(path[0] , path[1]);
    }
    public int[] dfs(TreeNode root){
        if(root == null ) return new int[]{0,0};
        int[] curr = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        curr[0] = root.val + left[1] + right[1];
        curr[1] = Math.max(left[1] ,left[0]) + Math.max(right[1] ,right[0]);
        return curr;
    }
}