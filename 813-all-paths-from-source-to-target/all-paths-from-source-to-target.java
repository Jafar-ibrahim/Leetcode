class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target= graph.length-1;
        //boolean[] visited = new boolean[graph.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph,ans,new ArrayList<>(),0,target);
        return ans; 
    }

    public static void dfs(int[][] graph,List<List<Integer>> ans ,ArrayList<Integer> curr , int node , int target){
        curr.add(node);
        if(node == target){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0 ; i < graph[node].length ; i++){
            dfs(graph,ans,curr,graph[node][i],target);
            curr.remove(curr.size()-1);
        }
    }
}