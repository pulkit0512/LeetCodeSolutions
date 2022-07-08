class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int orgColor;
    boolean[][] vis;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        orgColor = image[sr][sc];
        vis = new boolean[image.length][image[0].length];
        floodFillUtil(image, sr, sc, color);
        return image;
    }
    private void floodFillUtil(int[][] image, int sr, int sc, int color){
        if(vis[sr][sc]){
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        for(int i=0;i<4;i++){
            int newRow = sr+dir[i][0];
            int newCol = sc+dir[i][1];
            if(newRow>=0 && newRow<image.length && newCol>=0 && newCol<image[0].length && image[newRow][newCol]==orgColor){
                floodFillUtil(image, newRow, newCol, color);
            }
        }
    }
}