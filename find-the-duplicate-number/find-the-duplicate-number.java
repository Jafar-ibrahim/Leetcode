class Solution {
    public int findDuplicate(int[] nums) {
        int[] map =new int[nums.length+1];
        for(int n:nums){
            map[n]++;
            if(map[n] > 1)
                return n;
        }
        return -1;
    }
}