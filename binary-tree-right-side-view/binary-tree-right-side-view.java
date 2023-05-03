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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return answer;

        queue.add(root);
        TreeNode popped = null;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 1 ; i <= len ; i++){
                popped = queue.poll();
                if(popped.left != null)
                    queue.add(popped.left);
                if(popped.right != null)
                    queue.add(popped.right);
            }
            answer.add(popped.val);
        }
        return answer;
    }
}