class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0,fast=0;
        while(slow < nums.length-1 && fast < nums.length){
            if((nums[fast] > nums[slow])){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}