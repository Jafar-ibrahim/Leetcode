class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1 , counter = 0;
        while(s.charAt(end) == ' ')
            end--;
        
        while(end >= 0 && s.charAt(end) != ' '){
            counter++;
            end--;
        }
            

        return counter;
    }
}