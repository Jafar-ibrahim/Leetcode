class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp_grid = new int[text1.length()+1][text2.length()+1];
        char[] text1_arr = text1.toCharArray();
        char[] text2_arr = text2.toCharArray();
         for(int i = text1.length()-1 ; i >=0  ; i--){
              for(int j = text2.length()-1 ; j >=0  ; j--){
                if(text1_arr[i] == text2_arr[j]){
                    dp_grid[i][j] = 1 + dp_grid[i+1][j+1];
                }else{
                    dp_grid[i][j] = Math.max(dp_grid[i][j+1],dp_grid[i+1][j]);
                }
         }
         }
         return dp_grid[0][0];
    }
}