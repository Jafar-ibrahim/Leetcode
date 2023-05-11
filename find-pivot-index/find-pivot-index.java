class Solution {
    public int pivotIndex(int[] nums) {
        int[] cumulative  = new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            cumulative[i] = sum;
        }
       int prev = 0 , max=cumulative[cumulative.length-1];
       for(int i=0;i<cumulative.length;i++){
            if(max - cumulative[i] == prev) return i;
            prev = cumulative[i];
        }
        return -1;
    }
}