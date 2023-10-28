class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        Set<Integer> done = new LinkedHashSet<>();

        for(int[] edge : prerequisites){
            if(adj[edge[0]] == null)
                adj[edge[0]] = new ArrayList<>();
            adj[edge[0]].add(edge[1]);
        }

        for(int i = 0 ; i < numCourses  ; i++){
            if(!visited[i] && !helper(adj,visited,done,i))
                return new int[]{};
        }
        return done.stream().mapToInt(i -> i).toArray();
    }

    public static boolean helper(ArrayList<Integer>[] adj
            , boolean[] visited,  Set<Integer> done, int curr){

        if (visited[curr]) return false;
        if (done.contains(curr)) return true;

        visited[curr] = true;
        boolean result = true;



        if (adj[curr] != null)
            for(int i = 0 ; i < adj[curr].size() && result ; i++){
                int n = adj[curr].get(i);

                if (!helper(adj, visited, done, n))
                    return false;

            }
        done.add(curr);
        visited[curr] = false;
        return result;
    }
}