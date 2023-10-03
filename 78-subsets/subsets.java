class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<Integer>());
        for(int n : nums ){
            generate(answer,new ArrayList<>(),n);
        }
        return answer;
    }
    void generate(List<List<Integer>> answer ,List<List<Integer>> curr, int n){
        for(List<Integer> list : answer){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(n);
            curr.add(temp);
        }
        
        for(List<Integer> list : curr){
            answer.add(list);
        }
    }
    
    }
