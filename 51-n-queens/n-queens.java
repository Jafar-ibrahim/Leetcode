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

        boolean[][] bool = new boolean[4][];
        bool[0] = new boolean[n];
        bool[1] = new boolean[n];
        bool[2] = new boolean[2*n - 1];
        bool[3] = new boolean[2*n - 1];

        backtrack(answer,board,bool,0,n);
        return answer;
    }


    public static void backtrack(List<List<String>> answer ,char[][] board, boolean[][] bool , int row  , int n){

        if( n == 0 ){
            answer.add(boardString(board));
            return;
        }

            for(int j = 0 ; j < board.length ; j++){
                if(bool[1][j] || bool[2][row+j] || bool[3][(board.length -1) - row +j]) continue;
                bool[0][row] = true ;
                bool[1][j] = true ;
                bool[2][row+j] = true ;
                bool[3][(board.length -1) - row +j] = true ;
                board[row][j] = 'Q';
                backtrack(answer,board,bool,row + 1,n-1);
                board[row][j] = '.';
                bool[0][row] = false ;
                bool[1][j] = false ;
                bool[2][row+j] = false ;
                bool[3][(board.length -1) - row +j] = false ;

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