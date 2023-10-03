class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, answer ,new ArrayList<>(), visited ,0);
        return answer;
    }

    public static void backtrack(int[] nums ,  List<List<Integer>> answer,ArrayList<Integer> curr, boolean[] visited , int index ){

        answer.add(new ArrayList(curr));

        for(int i =index ; i<nums.length ; i++){
            if(visited[i] ||i > 0 && nums[i-1] == nums[i] && !visited[i-1])continue;
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(nums , answer ,curr , visited , i +1);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}