import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }

        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        boolean[] diagLeft  = new boolean[2*n - 1];
        boolean[] diagRight  = new boolean[2*n - 1];

        backtrack(answer,board,rows,cols,diagLeft,diagRight,0,0,n);
        return answer;
    }


    public static void backtrack(List<List<String>> answer ,char[][] board, boolean[] rows , boolean[] cols  , boolean[] diagLeft,boolean[] diagRight , int row , int col , int n){

        if( n == 0 ){
            answer.add(boardString(board));
            return;
        }


        for(int i = row ; i < board.length ; i++){
            if(rows[i]) continue;
            for(int j = 0 ; j < board.length ; j++){
                if(cols[j] || diagLeft[i+j] || diagRight[(board.length -1) - i +j]) continue;
                rows[i] = true ;
                cols[j] = true ;
                diagLeft[i+j] = true ;
                diagRight[(board.length -1) - i +j] = true ;
                board[i][j] = 'Q';
                backtrack(answer,board,rows,cols,diagLeft,diagRight,i,j,n-1);
                board[i][j] = '.';
                rows[i] = false ;
                cols[j] = false ;
                diagLeft[i+j] = false ;
                diagRight[(board.length -1) - i +j] = false ;

            }
        }
    }

    public static List<String> boardString(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] row : board){
            StringBuilder sb = new StringBuilder();
            for(char c : row){
                sb.append(c);
            }
            result.add(sb.toString());
        }
        return result;
    }

}