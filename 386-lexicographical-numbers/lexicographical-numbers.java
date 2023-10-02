class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        generate(1 ,9 , n , answer);
        return answer;
    }

    public static void generate(int curr ,int max , int n , List<Integer> answer){
        if(curr > n || curr > max || curr <= 0)
            return;

        answer.add(curr );
        int pow = 0;
        int temp = curr;
        
        generate(curr*10 , curr*10 +9 , n , answer);
        generate(curr + 1 , max ,  n , answer);
    }
}