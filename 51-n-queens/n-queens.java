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


        for(int i = row ; i < board.length ; i++){
            if(bool[0][i]) continue;
            for(int j = 0 ; j < board.length ; j++){
                if(bool[1][j] || bool[2][i+j] || bool[3][(board.length -1) - i +j]) continue;
                bool[0][i] = true ;
                bool[1][j] = true ;
                bool[2][i+j] = true ;
                bool[3][(board.length -1) - i +j] = true ;
                board[i][j] = 'Q';
                backtrack(answer,board,bool,i + 1,n-1);
                board[i][j] = '.';
                bool[0][i] = false ;
                bool[1][j] = false ;
                bool[2][i+j] = false ;
                bool[3][(board.length -1) - i +j] = false ;

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