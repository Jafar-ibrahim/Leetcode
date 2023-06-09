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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer= new ArrayList<>();
        traverse(root , answer);
        return answer;
    }
    public void traverse(TreeNode root , List<Integer> answer){
        if(root == null) return;
        traverse(root.left,answer);
        traverse(root.right,answer);
        answer.add(root.val);
    }
}