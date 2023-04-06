class Solution {
    public static boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        int last = 0;
        for(int i = 0 ; i<nums.length-2 && nums[i]!=0;){
            int max =-1 , index=i;
            if( last + nums[last] >= nums.length-1)
                return true;
            for(int j = i+1 ; j<nums.length-1 && j<i+1+nums[i] ; j++){
                if(j+nums[j]>=max){
                    max = j+nums[j] ;
                    index=j;
                }
            }
            last = index;
            i = index;
        }
            return last + nums[last] >= nums.length-1;
    }
}