class Solution {
    public static boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        if(nums[0]==0)return false;
        int lastMaxIndex = 0;

        for(int i = 0 ; i<nums.length-2 && nums[i]!=0;){
            int max =-1 , currentMaxIndex=i;
            if( lastMaxIndex + nums[lastMaxIndex] >= nums.length-1)
                return true;
            for(int j = i+1 ; j<nums.length-1 && j<i+1+nums[i] ; j++){
                if(j+nums[j]>=max){
                    max = j+nums[j] ;
                    currentMaxIndex=j;
                }
            }
            lastMaxIndex = currentMaxIndex;
            i = currentMaxIndex;
        }
            return lastMaxIndex + nums[lastMaxIndex] >= nums.length-1;
    }
}