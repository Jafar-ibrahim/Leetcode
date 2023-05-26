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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> answer = new ArrayList<>();
        traverse(root,answer,k);
        return answer.get(k-1);
    }
    public void traverse(TreeNode root , List<Integer> answer ,  int k){
        if(root == null || answer.size() >= k) return;
        traverse(root.left,answer,k);
        answer.add(root.val);
        traverse(root.right,answer,k);
    }
}