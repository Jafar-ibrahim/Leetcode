class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, answer ,new ArrayList<>(),0);
        return answer;
    }

    public static void backtrack(int[] nums ,  List<List<Integer>> answer,ArrayList<Integer> curr, int index ){

        answer.add(new ArrayList(curr));

        for(int i =index ; i<nums.length ; i++){
            if(i > index && nums[i-1] == nums[i] )continue;
            curr.add(nums[i]);
            backtrack(nums , answer ,curr , i +1);
            curr.remove(curr.size()-1);
        }
    }
}