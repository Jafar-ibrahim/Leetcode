class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];

        for(int i=0 ; i<board.length ; i+=3){
            for(int j=0 ; j< board[0].length ; j+=3){
                int[] grid = new int[10];

                for(int row=i ; row < i+3 ; row++){
                    for(int col = j ; col <j+3 ; col++){
                        char curr = board[row][col];
                        if(curr != '.'){
                            grid[curr-'0']++;
                            rows[row][curr-'0']++;
                            cols[col][curr-'0']++;
                            if(grid[curr-'0'] > 1 
                            ||rows[row][curr-'0'] >1 
                            ||cols[col][curr-'0'] >1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
        }
}