class Solution {
    public boolean exist(char[][] board, String word) {
    
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(board[i][j] == word.charAt(0) && backtrack(board,word,visited,i,j,0)){
                    return true;
                }
            }
        }
    return false;
    }

    public static boolean backtrack (char[][] board, String word,boolean[][] visited , int row , int col , int index ){

        if(index == word.length()) return true;
        
        if(row < 0 || col < 0 ||
         row > board.length-1 ||
        col > board[0].length-1) return false;

       
        if(visited[row][col] || board[row][col] != word.charAt(index)) return false;
         
       

            visited[row][col] = true;
        boolean left =  backtrack(board,word,visited,row,col-1,index+1);
        boolean up = backtrack(board,word,visited,row-1,col,index+1);
        boolean right = backtrack(board,word,visited,row,col+1,index+1);
        boolean down = backtrack(board,word,visited,row+1,col,index+1);
            visited[row][col] = false;

        return left || up || right || down ;
    }
    
}