class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        if(numRows > 1) 
           answer.add(List.of(1,1));
         
        while(numRows > 2 ){
            List<Integer> prevRow = answer.get(answer.size()-1);
            List<Integer> curr = new ArrayList<>();
            for(int i=0;  i<prevRow.size()+1 ; i++){
                curr.add(1);
            }
            for(int i=0 ; i< prevRow.size()-1 ; i++){
                int sum = prevRow.get(i) + prevRow.get(i+1);   
                curr.set(i+1 , sum);
            }
            answer.add(curr);
            
            numRows--;
        }
        
        return answer;
       
 
    }
}