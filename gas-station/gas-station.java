class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for(int i=0 ; i< diff.length ; i++){
            diff[i] = gas[i] - cost[i];
        }
        int curr = 0 , total =0,index = 0 ;
        for(int i=0 ; i< diff.length ; i++){
            curr+= diff[i];
            total += diff[i];
            if(curr < 0) {
                curr = 0;
                index = i+1;
            }
        }
        
        return (total < 0)? -1 : index;
    }
}