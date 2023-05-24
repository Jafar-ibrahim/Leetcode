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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        add(root,list);
        Collections.sort(list);
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            answer=Math.min(answer,Math.abs((list.get(i)-list.get(i-1))));
        }
        return answer;
    }
    public void add(TreeNode root,List<Integer> list){
        if(root==null) return;
        add(root.left,list);
        add(root.right,list);
        list.add(root.val);
    }
}