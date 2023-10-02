class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums ,new ArrayList<Integer>(), answer ,visited );
        return answer;
    }

    public static void backtrack(int[] nums , ArrayList<Integer> curr, List<List<Integer>> answer , boolean visited[]){

        // 1 2 3 4 5 6
        if(curr.size() == nums.length){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0 ; i < nums.length ; i++){
            if(visited[i] || i > 0 && !visited[i-1] && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums, curr , answer , visited );
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}