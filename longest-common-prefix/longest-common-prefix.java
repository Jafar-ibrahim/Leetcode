class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==1 ) return strs[0];
        Arrays.sort(strs);
        StringBuilder str = new StringBuilder();
        int last = strs.length -1;
        for(int i = 0 ; i< Math.min(strs[0].length(),strs[last].length());i++){
            if(strs[0].charAt(i) != strs[last].charAt(i))
                break;
            str.append(strs[0].charAt(i));
        }
        return str.toString();
    }
}