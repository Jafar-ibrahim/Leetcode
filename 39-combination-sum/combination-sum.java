class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, answer , new ArrayList() , target , 0,0);
        return answer;
    }

    public static void backtrack(int[] candidates , List<List<Integer>> answer , ArrayList<Integer> curr , int target , int index , int sum){

        if(sum > target) return;
        if(sum == target){
            answer.add(new ArrayList(curr));
            return;
        }

        for(int i = index ; i < candidates.length && candidates[i]<=target; i++){
            curr.add(candidates[i]);
            backtrack(candidates,answer,curr,target,i,sum+candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}