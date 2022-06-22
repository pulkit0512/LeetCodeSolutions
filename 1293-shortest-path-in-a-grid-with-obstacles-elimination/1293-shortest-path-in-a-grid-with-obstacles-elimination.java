class Solution {
    int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> pq = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        pq.add(new int[]{0,0,0,0});
        set.add("0_0_0");
        int minSteps = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            if(cur[0]==m-1 && cur[1]==n-1){
                minSteps = cur[3];
                break;
            }
            for(int i=0;i<4;i++){
                int newRow = dir[i][0] + cur[0];
                int newCol = dir[i][1] + cur[1];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                    String s0 = new StringBuilder().append(newRow)
                        .append('_').append(newCol).append('_').append(cur[2]).toString();
                    String s1 = new StringBuilder().append(newRow)
                        .append('_').append(newCol).append('_').append(cur[2]+1).toString();
                    if(grid[newRow][newCol]==0 && !set.contains(s0)){
                        pq.add(new int[]{newRow, newCol, cur[2], cur[3]+1});
                        set.add(s0);
                    }else if(grid[newRow][newCol]==1 && cur[2]+1<=k && !set.contains(s1)){
                        pq.add(new int[]{newRow, newCol, cur[2]+1, cur[3]+1});
                        set.add(s1);
                    }
                }
            }
        }
        return minSteps==Integer.MAX_VALUE?-1:minSteps;
    }
}