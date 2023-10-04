class Solution {
    int answer = 0;
    public int subsetXORSum(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums , new ArrayList<>() , 0);
    
        return answer;
    }
    void backtrack( int[] nums , ArrayList<Integer> subset , int index){
        
        answer += bitwiseOR(subset);
        
        for(int i = index; i < nums.length ; i++){
            //if( i > index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(nums , subset , i+1);
            subset.remove(subset.size()-1);
        }
    }

    public static int bitwiseOR(List<Integer> subset){
        if(subset.isEmpty())
            return 0;
        int temp = 0;
        for(int n : subset){
            temp ^= n;
        }
        return temp;
    }
}