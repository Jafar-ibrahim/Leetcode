class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        backtrack(n ,k,new ArrayList<Integer>(), answer ,1 );
        return answer;
    }

    public static void backtrack(int n ,int k , ArrayList<Integer> curr, List<List<Integer>> answer , int index){

        // 1 2 3 4 5 6
        if(curr.size() == k){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index ; i <= n ; i++){
            curr.add(i);
            //visited[i] = true;
            backtrack(n,k, curr , answer , i+1 );
            //visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}