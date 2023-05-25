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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reversed = false;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size =queue.size(); 
            for(int i=0 ; i<size;i++){
                TreeNode curr = queue.remove();
                if(curr != null){
                    temp.add(curr.val);
                    
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            if(!temp.isEmpty()){
                if(reversed)
                    Collections.reverse(temp);
                answer.add(temp);
            }
            reversed = (reversed == true)? false : true;
        }

        return answer;
    }
}