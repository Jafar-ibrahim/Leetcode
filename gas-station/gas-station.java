class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for(int i=0 ; i< diff.length ; i++){
            diff[i] = gas[i] - cost[i];
        }
        int curr = 0 , index = 0 ;
        for(int i=0 ; i< diff.length ; i++){
            curr+= diff[i];
            if(curr < 0) {
                curr = 0;
                index = i+1;
                continue;
            }
        }
        if(curr == 0 && index > 0) return -1;
        for(int i=0 ; i< index ; i++){
            curr += diff[i];
            if(curr < 0) {
                return -1;
            }
        }
        return index;
    }
}