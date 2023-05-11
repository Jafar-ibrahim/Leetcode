class Solution {
    public int pivotIndex(int[] nums) {
        // make a prefix sum array with one more element to store 0 as the fist value
        int[] cumulative  = new int[nums.length+1];
        cumulative[0]=0;
        int sum=0;
        // fill prefix sum array
        for(int i=1;i<=nums.length;i++){
            cumulative[i] = cumulative[i-1] + nums[i-1];
        }
        // subtract the current sum from the greatest sum until the result equals the sum before the currnt index  
       for(int i=1;i<cumulative.length;i++){
           // is equal , return the index subtracted by one to align with the original array's index 
            if(cumulative[cumulative.length-1] - cumulative[i] == cumulative[i-1]) return i-1;
        }
        return -1;
    }
}