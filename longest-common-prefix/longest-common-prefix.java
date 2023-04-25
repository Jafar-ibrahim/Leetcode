class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        int minLength = strs[0].length();
        StringBuilder str = new StringBuilder();

        for(int i=1 ; i<strs.length;i++){
            minLength = Math.min(minLength,strs[i].length());
        }
        for(int j=0 ; j< minLength ;j++){
            char c = strs[0].charAt(j);
            for(int i=0 ; i<strs.length ; i++){
                if(strs[i].charAt(j) != c) return str.toString();
            }
            str.append(c);
        } 
        return str.toString();
        
    }
}