class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        Set<Integer> doable = new HashSet<>();
        boolean result = true;

        for(int[] edge : prerequisites){
            if(adj[edge[0]] == null)
                adj[edge[0]] = new ArrayList<>();
            adj[edge[0]].add(edge[1]);
        }

        for(int i = 0 ; i < numCourses && result ; i++){
            if(!visited[i])
                result = result && helper(adj,visited,doable,i);
        }

        return result;
    }

    public static boolean helper(ArrayList<Integer>[] adj
            , boolean[] visited,  Set<Integer> doable, int curr){

        visited[curr] = true;
        boolean result = true;
        if (adj[curr] != null)
            for(int i = 0 ; i < adj[curr].size() && result ; i++){
                int n = adj[curr].get(i);

                if (!visited[n])
                    result = result && helper(adj, visited, doable, n);

                else if (!doable.contains(n))
                    return false;
            }
        doable.add(curr);
        return result;
    }
}