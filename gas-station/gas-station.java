class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int curr = 0 , total =0,index = 0 ;
        for(int i=0 ; i< gas.length ; i++){
            curr+=  gas[i] - cost[i];;
            total +=  gas[i] - cost[i];;
            if(curr < 0) {
                curr = 0;
                index = i+1;
            }
        }
        
        return (total < 0)? -1 : index;
    }
}