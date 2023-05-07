class Solution {
    
    //Runtime: 106 ms, faster than 29.54% of Java online submissions for 3Sum.
    //Memory Usage: 70.8 MB, less than 23.87% of Java online submissions for 3Sum.
    //HashMap
    //Time:O(N * logN + N * N); Space: O(N + logN + N)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], i);

        for(int i = 0; i < nums.length - 2 && nums[i] <= 0;){
            for (int j = i + 1; j < nums.length && nums[i] + nums[j] <= 0;) {
                int value = 0 - nums[i] - nums[j];
                //if (value < 0) break;
                if (value < 0) return new ArrayList<>(resultSet);
                if (value < nums[j]) break;
                if (map.containsKey(value) && map.get(value) > j)
                    resultSet.add(Arrays.asList(nums[i], nums[j], value));
                j++;
                while(j < nums.length && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        return new ArrayList<>(resultSet) ;
    }
}