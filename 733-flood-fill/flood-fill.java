class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        dfs(image,sr,sc,originalColor,color);
        return image;
    }

    public static void dfs(int[][] image, int row, int col,int originalColor, int color){
        int curr = image[row][col];
        if( curr == color || curr != originalColor ) return;

        image[row][col] = color;

        if(row+1 < image.length) 
            dfs(image,row+1,col,originalColor,color);
        if(row-1 > -1 )
            dfs(image,row-1,col,originalColor,color);
        if(col+1 < image[0].length)
            dfs(image,row,col+1,originalColor,color);
        if(col-1 > -1)
            dfs(image,row,col-1,originalColor,color);

    }
}