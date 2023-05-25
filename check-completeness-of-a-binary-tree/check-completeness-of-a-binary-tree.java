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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode prev =root;
        
        while(!queue.isEmpty()){
             TreeNode curr = queue.remove();
             if(prev == null && curr != null) return false;
             prev = curr;
             if(curr != null) {
                 queue.add(curr.left);
                 queue.add(curr.right);
             }
        }
        return true; 
    }
}