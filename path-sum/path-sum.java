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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return traverse(root,0,targetSum);
            
    }
    public boolean traverse(TreeNode root,int curr_sum ,int targetSum){
        if(root==null)
             return false;
        if(targetSum == curr_sum+root.val 
        && root.left == null && root.right == null ) return true;
        return traverse(root.left,curr_sum + root.val , targetSum) 
            || traverse(root.right,curr_sum + root.val , targetSum); 

    }
}