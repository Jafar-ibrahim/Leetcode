class Solution {
    public int jump(int[] nums) {
        if(nums.length < 3 ) return nums.length-1;
        int count = 0;
        for(int i = 0 ; i<nums.length-1 ;  ){
            int maxNum = -1 , maxIndex = i;
            
            count++;
            if(i + nums[i] >= nums.length-1)
                break;
            
            for(int j = i+1 ; j<nums.length-1 && j<i+1+nums[i] ; j++){
                if(j+nums[j] >= maxNum){
                    maxNum = j+nums[j];
                    maxIndex = j ;
                }
                
            }
            
            i=maxIndex;
        }

        return count;
    }
}