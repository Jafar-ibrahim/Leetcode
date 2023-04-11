class Solution {
    public String removeStars(String s) {
        StringBuilder answer = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c!='*')
                answer.append(c);
            else
                answer.deleteCharAt(answer.length()-1);
        }
        return answer.toString();
    }
}