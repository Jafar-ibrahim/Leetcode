class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        /*for(int i = 1 ; i <= Math.min(n,9) ; i++){
            answer.add(i);
            generate(i*10 ,i*10 + 10, n , answer);
        }*/
        generate(1 ,9 , n , answer);
        return answer;
    }

    public static void generate(int curr ,int max , int n , List<Integer> answer){
        if(curr > n || curr > max || curr <= 0)
            return;

        answer.add(curr );
        int pow = 0;
        int temp = curr;
        /*int nextBound = curr * (int) Math.pow(10,pow);*/
        
        /*while(temp > 10){
            temp /= 10;
            pow++;
        }*/
        
        generate(curr*10 , curr*10 +9 /*nextBound+(int)Math.pow(10,pow)-1*/ , n , answer);
        generate(curr + 1 , max ,  n , answer);
    }
}