class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer , Integer> map = new HashMap<>();
        for(int a : nums){
                map.put(a,map.getOrDefault(a,0)+1);
        }
        int curr = 0;
        while(curr<nums.length){
            map.put(nums[curr],map.get(nums[curr])-1);
            int curr_target = target - nums[curr];
            if(map.containsKey(curr_target) && map.get(curr_target) > 0){
                answer[0]=curr;
                for(int i = curr+1 ; i<nums.length ; i++){
                    if(nums[i]==curr_target){
                        answer[1]=i;
                        break;
                    }
                }
                break;
            }
            curr++;
        }
        return answer;
    }
}