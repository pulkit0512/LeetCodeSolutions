class Solution {
    int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> points = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];
        
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<heights.length;i++){
            que.add(new int[]{i, 0});
        }
        for(int i=0;i<heights[0].length;i++){
            que.add(new int[]{0, i});
        }
        bfs(heights, pacificReachable, que);
        
        for(int i=0;i<heights.length;i++){
            que.add(new int[]{i, n-1});
        }
        for(int i=0;i<heights[0].length;i++){
            que.add(new int[]{m-1, i});
        }
        bfs(heights, atlanticReachable, que);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j]){
                    points.add(List.of(i, j));
                }
            }
        }
        
        return points;
    }
    
    private void bfs(int[][] heights, boolean[][] reachable, Queue<int[]> que) {
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            reachable[cur[0]][cur[1]] = true;
            
            for(int d[]:dir){
                int newRow = cur[0] + d[0];
                int newCol = cur[1] + d[1];
                if(newRow<0 || newCol<0 || newRow>=heights.length || newCol>=heights[0].length){
                    continue;
                }
                if(reachable[newRow][newCol]){
                    continue;
                }
                if(heights[newRow][newCol]>=heights[cur[0]][cur[1]]){
                    que.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}