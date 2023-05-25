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
        int level =0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size =queue.size(); 
            for(int i=0 ; i<size;i++){
                TreeNode curr = queue.remove();
                if(curr != null){
                    if(level % 2 == 0)
                        temp.add(curr.val);
                    else
                        temp.add(0,curr.val);
                    
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            if(!temp.isEmpty()){
                answer.add(temp);
            }
            level++;
        }

        return answer;
    }
}