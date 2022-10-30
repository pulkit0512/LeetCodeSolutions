class Solution {
    int dir[][] = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(k>=m+n-2){
            return m+n-2;
        }
        
        // Will have an integer array of size 4
        // arr[0] = x coordinate, arr[1] = y coordinate, arr[2] = obstacles removed till now, arr[3] = steps till now.
        Queue<int[]> que = new LinkedList<>();
        // x-coordinate_y-coordinate_obstaclesRemoved
        Set<String> set = new HashSet<>();
        
        que.add(new int[]{0, 0, 0, 0});
        set.add("0_0_0");
        
        while(!que.isEmpty()) {
            int cur[] = que.poll();
            if(cur[0]==m-1 && cur[1]==n-1){
                return cur[3];
            }
            
            for(int i=0;i<4;i++){
                int newRow = dir[i][0] + cur[0];
                int newCol = dir[i][1] + cur[1];
                
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n) {
                    String noObstacle = new StringBuilder()
                        .append(newRow).append('_')
                        .append(newCol).append('_')
                        .append(cur[2]).toString();
                
                    String obstacle = new StringBuilder()
                        .append(newRow).append('_')
                        .append(newCol).append('_')
                        .append(cur[2]+1).toString();
                    
                    if(grid[newRow][newCol]==0 && !set.contains(noObstacle)){
                        que.add(new int[]{newRow, newCol, cur[2], cur[3]+1});
                        set.add(noObstacle);
                    }else if(grid[newRow][newCol]==1 && cur[2]+1<=k && !set.contains(obstacle)){
                        que.add(new int[]{newRow, newCol, cur[2]+1, cur[3]+1});
                        set.add(obstacle);
                    }
                }
                
            }
        }
        
        return -1;
    }
}