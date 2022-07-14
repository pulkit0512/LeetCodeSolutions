class Solution {
    int dir[][] = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    class Triplet {
        int row, col, time;
        public Triplet(int a, int b, int c){
            row = a;
            col = b;
            time = c;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> que = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    que.add(new Triplet(i, j, 0));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int ans = 0;
        while(!que.isEmpty()){
            Triplet cur = que.poll();
            ans = Math.max(ans, cur.time);
            for(int i=0;i<4;i++){
                int newRow = cur.row + dir[i][0];
                int newCol = cur.col + dir[i][1];
                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1){
                    que.add(new Triplet(newRow, newCol, cur.time+1));
                    grid[newRow][newCol] = 2;
                    fresh--;
                }
            }
        }
        return fresh==0?ans:-1;
    }
}