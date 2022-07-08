class Solution {
    public int islandPerimeter(int[][] grid) {
        int cntOne = 0;
        int hor = 0, ver = 0;
        for(int i=0;i<grid.length;i++){
            int horCnt = 0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    cntOne++;
                    horCnt++;
                }else {
                    if(horCnt>0){
                        hor += horCnt-1;
                        horCnt = 0;
                    }
                }
            }
            if(horCnt>0){
                hor += horCnt-1;
            }
        }
        for(int j=0;j<grid[0].length;j++){
            int verCnt = 0;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1){
                    verCnt++;
                }else {
                    if(verCnt>0){
                        ver += verCnt-1;
                        verCnt = 0;
                    }
                }
            }
            if(verCnt>0){
                ver += verCnt-1;
            }
        }
        //System.out.println(hor+" "+ver);
        return 4*cntOne - 2*(hor+ver);
    }
}