class Solution {
     public static List<String> generateParenthesis(int n) {
        StringBuilder simple = new StringBuilder();
        List<String> answer = new ArrayList<>();
         helper(answer,simple,0,0,n);
         return answer;
    }
    public static void helper( List<String> answer,StringBuilder curr,int open , int close , int size ){
        if(close == size && open==size){
            answer.add(curr.toString());
        }else{
                if(open < size){
                    curr.append('(');
                    helper(answer,curr,open+1,close,size);
                    curr.deleteCharAt(curr.length()-1);
                }
                if(open > close){
                    curr.append(')');
                    helper(answer,curr,open,close+1,size);
                    curr.deleteCharAt(curr.length()-1);
            }

        }
    }
}