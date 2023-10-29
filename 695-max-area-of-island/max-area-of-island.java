class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int answer = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1)
                    answer = Math.max(answer,dfs(grid,i,j));
            }
        }

        return answer;
        
    }

    public static int dfs(int[][] grid,int row , int col){
        if(grid[row][col] == 0 ) return 0;

        grid[row][col] = 0;
        int answer = 1 ;
        if(row+1 < grid.length) 
            answer += dfs(grid,row+1,col);
        if(row-1 > -1 )
           answer += dfs(grid,row-1,col);
        if(col+1 < grid[0].length)
            answer += dfs(grid,row,col+1);
        if(col-1 > -1)
            answer += dfs(grid,row,col-1);

        return answer;
    }
}