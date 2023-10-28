import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean result = true;

        for(int[] edge : prerequisites){
            if(adj[edge[0]] == null)
                adj[edge[0]] = new ArrayList<>();
            adj[edge[0]].add(edge[1]);
        }

        for(int i = 0 ; i < numCourses && result ; i++){
            if(!visited[i])
                result = result && helper(adj,visited,stack,i);
        }

        return result;
    }

    public static boolean helper(ArrayList<Integer>[] adj
            , boolean[] visited, Stack<Integer> stack, int curr){

        visited[curr] = true;
        boolean result = true;
        if (adj[curr] != null)
            for(int i = 0 ; i < adj[curr].size() && result ; i++){
                int n = adj[curr].get(i);

                if (visited[n]  && !stack.contains(n))
                    return false;

                if (!visited[n])
                    result = result && helper(adj, visited, stack, n);
            }
        stack.add(curr);
        return result;
    }
}