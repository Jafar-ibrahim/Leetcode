class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0,slow=0;
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast!=slow);

        int slow_2 =0;
        while(slow != slow_2){
            slow = nums[slow];
            slow_2 = nums[slow_2];
        }
        return slow;
    }
}