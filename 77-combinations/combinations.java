class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), answer ,1,n,k );
        return answer;
    }

    public static void backtrack( ArrayList<Integer> curr, List<List<Integer>> answer , int index, int n ,int k ){

        if(k== 0){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index ; i <= n-k + 1 ; i++){
            curr.add(i);
            backtrack(curr , answer , i+1 ,n,k-1);
            curr.remove(curr.size()-1);
        }
    }
}