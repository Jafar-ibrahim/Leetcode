class Solution {
    public int removeDuplicates(int[] nums) {
        int start=0 , ptr=0 ,count=1;
        while(start < nums.length-1 && ptr < nums.length){
            if((nums[ptr] > nums[start])){
                nums[++start] = nums[ptr];
                count++;
            }
            ptr++;
        }
        return count;
    }
}