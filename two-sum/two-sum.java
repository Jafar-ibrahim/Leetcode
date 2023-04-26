class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
                map.put(nums[i],i);
        }
        int curr = 0;
        while(curr<nums.length){
            int curr_target = target - nums[curr];
            if(map.get(curr_target) != null && map.get(curr_target)!= curr){
                return new int[] { curr, map.get(curr_target)};
            }
            curr++;
        }
        return null;
    }
}