class Solution {
    public int pivotIndex(int[] nums) {
        int[] cumulative  = new int[nums.length+1];
        cumulative[0]=0;
        int sum=0;
        for(int i=1;i<=nums.length;i++){
            cumulative[i] = cumulative[i-1] + nums[i-1];
        }
       for(int i=1;i<cumulative.length;i++){
            if(cumulative[cumulative.length-1] - cumulative[i] == cumulative[i-1]) return i-1;
        }
        return -1;
    }
}