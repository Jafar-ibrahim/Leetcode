class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -2,0,1,1,2
        Set<List<Integer>> answer = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i],i);
        }
       
        for(int i=0 ; i<nums.length-2 ; i++){
            int target = -1*(nums[i]);
            for(int k=i+1 ; k<nums.length-1 ; k++){
                if(map.get(target - nums[k]) != null &&
                   map.get(target - nums[k]) > k )
                    answer.add(List.of(nums[i],target - nums[k],nums[k]));
            }
            
        }
        List<List<Integer>> full = new ArrayList<>(answer);
        return full;
    }
}