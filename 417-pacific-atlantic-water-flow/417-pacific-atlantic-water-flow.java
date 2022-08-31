class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int water[][] = new int[m][n];
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            que.add(0*n + i);
        }
        for(int i=1;i<m;i++){
            que.add(i*n + 0);
        }
        bfs(heights, water, que);
        
        for(int i=0;i<n;i++){
            que.add((m-1)*n + i);
        }
        for(int i=0;i<m-1;i++){
            que.add(i*n + n-1);
        }
        bfs(heights, water, que);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(water[i][j]==2){
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    
    private void bfs(int[][] heights, int[][] water, Queue<Integer> que) {
        int m = heights.length;
        int n = heights[0].length;
        boolean vis[][] = new boolean[m][n];
        while(!que.isEmpty()) {
            int cur = que.poll();
            int r = cur/n;
            int c = cur%n;
            if(vis[r][c]){
                continue;
            }
            water[r][c]++;
            vis[r][c] = true;
            
            for(int i=0;i<4;i++){
                int newRow = r + dir[i][0];
                int newCol = c + dir[i][1];
                if(newRow<0 || newCol<0 || newRow>=m || newCol>=n || vis[newRow][newCol]){
                    continue;
                }
                
                if(heights[newRow][newCol]>=heights[r][c]){
                    que.add(newRow*n + newCol);
                }
            }
        }
    }
}