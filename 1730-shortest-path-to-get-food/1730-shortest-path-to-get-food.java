class Solution {
    class CellData {
        int row, col, steps;
        public CellData(int r, int c, int s) {
            row = r;
            col = c;
            steps = s;
        }
    }
    int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int getFood(char[][] grid) {
        Queue<CellData> que = new LinkedList<>();
        int srcX = -1, srcY = -1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='*'){
                    srcX = i;
                    srcY = j;
                }
            }
        }
        //System.out.println(srcX + " " + srcY);
        //System.out.println(destX + " " + destY);
        que.add(new CellData(srcX, srcY, 0));
        while(!que.isEmpty()){
            CellData cur = que.poll();
            if(grid[cur.row][cur.col]=='X'){
                continue;
            }
            //System.out.println(cur.row+" "+cur.col+" "+cur.steps);
            
            grid[cur.row][cur.col] = 'X';
            for(int[] d:dir){
                int newRow = cur.row + d[0];
                int newCol = cur.col + d[1];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length){
                    if(grid[newRow][newCol]=='O'){
                        que.add(new CellData(newRow, newCol, cur.steps+1));
                    }else if(grid[newRow][newCol]=='#') {
                        return cur.steps+1;
                    }
                }
            }
        }
        return -1;
    }
}