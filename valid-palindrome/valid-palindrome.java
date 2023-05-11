class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left =0 , right = chars.length-1;
        while(right > left){
            if(isAlphaNumeric(chars[left]) && isAlphaNumeric(chars[right])){
                if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
            right--;
            left++;
            }else{
                if(!isAlphaNumeric(chars[left]))
                    left++;
                if(!isAlphaNumeric(chars[right]))
                    right--;
            }
                
        }
        return true;
        
    }
     

    public static boolean isAlphaNumeric(char char1) {
        return (char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || (char1 >= '0' && char1 <= '9');
    }
}
