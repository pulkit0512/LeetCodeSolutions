class Solution {
    int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> points = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            que.add(0*n + i);
        }
        for(int i=1;i<m;i++){
            que.add(i*n + 0);
        }
        bfs(heights, pacificReachable, que);
        
        
        for(int i=0;i<n;i++){
            que.add((m-1)*n + i);
        }
        for(int i=0;i<m-1;i++){
            que.add(i*n + n-1);
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
    
    private void bfs(int[][] heights, boolean[][] reachable, Queue<Integer> que) {
        int m = heights.length;
        int n = heights[0].length;
        while(!que.isEmpty()){
            int cur = que.poll();
            int r = cur/n;
            int c = cur%n;
            if(reachable[r][c]){
                continue;
            }
            reachable[r][c] = true;
            
            for(int d[]:dir){
                int newRow = r + d[0];
                int newCol = c + d[1];
                if(newRow<0 || newCol<0 || newRow>=m || newCol>=n || reachable[newRow][newCol]){
                    continue;
                }
                
                if(heights[newRow][newCol]>=heights[r][c]){
                    que.add(newRow*n + newCol);
                }
            }
        }
    }
}