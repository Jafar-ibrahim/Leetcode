
class Solution {
   
    
    public int orangesRotting(int[][] grid) {
        int answer = 0 ;
        int temp = 0;
        int fresh = 0;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length;j++){
                if(grid[i][j] == 2){
                    Pair<Integer,Integer> rotten = new Pair(i,j);
                    q.add(rotten);
                }else
                {
                    if(grid[i][j] == 1)
                        fresh++;
                }
            }
        }


        

        while(q.peek() != null && fresh > 0 ){

            int len = q.size();
            for(int i = 0 ; i < len ; i++){
                Pair<Integer,Integer> rotten = q.poll();
                int row = rotten.getKey() , col = rotten.getValue();
                if(checkRot(row -1,col , grid,q )) fresh--;
                if(checkRot(row +1,col , grid,q )) fresh--;
                if(checkRot(row ,col-1, grid ,q)) fresh--;
                if(checkRot(row,col+1 , grid ,q)) fresh--;
            }
            answer++;
        }

        if(fresh > 0) return -1;

        return answer;
    }

    public static boolean checkRot(int row,int col , int[][] grid ,Queue<Pair<Integer,Integer>> q ){

        if(row  < grid.length && col < grid[0].length
                && row > -1 && col > -1){
            if(grid[row][col] == 1 ){
                q.add(new Pair<>(row,col));
                grid[row][col] = 2;
                return true;
            }
        }
            return false;
    }
}
