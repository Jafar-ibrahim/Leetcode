class Solution {
    public int lengthOfLastWord(String s) {
        int end  = s.length()-1 , answer = 0;
        while(end >=0 && s.charAt(end)==' ')
            end--;
        while(end >=0 && s.charAt(end)!=' '){
            answer++;
            end--;
        }
        return answer;
    }
}