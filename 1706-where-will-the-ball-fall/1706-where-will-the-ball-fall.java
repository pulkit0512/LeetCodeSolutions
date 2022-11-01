class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] ans = new int[n];
        
        for(int b=0;b<n;b++){
            int row = 0, col = b;
            while(row<m && col<n) {
                if(grid[row][col]==1) {
                    if(col+1<n && grid[row][col+1] == 1) {
                        row++;
                        col++;
                    }else {
                        break;
                    }
                }else{
                    if(col-1>=0 && grid[row][col-1] == -1) {
                        row++;
                        col--;
                    }else{
                        break;
                    }
                }
            }
            
            ans[b] = (row==m)? col : -1;
        }
        
        return ans;
    }
}