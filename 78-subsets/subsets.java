class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for(int n : nums){
            int len = answer.size();
            for(int i = 0 ; i < len ; i++){
                List<Integer> curr = new ArrayList(answer.get(i));
                curr.add(n);
                answer.add(curr);
            }
        }
        return answer;
    }

}