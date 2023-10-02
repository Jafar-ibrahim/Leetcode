class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(n ,k,new ArrayList<Integer>(), answer ,1 );
        return answer;
    }

    public static void backtrack(int n ,int k , ArrayList<Integer> curr, List<List<Integer>> answer , int index){

        if(curr.size() == k){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index ; i <= n ; i++){
            curr.add(i);
            backtrack(n , k, curr , answer , i+1 );
            curr.remove(curr.size()-1);
        }
    }
}