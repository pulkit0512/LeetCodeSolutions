class Solution {
    public int findLonelyPixel(char[][] picture) {
        //return findLonelyPixelLinearSpace(picture);
        return findLonelyPixelConstantSpace(picture);
    }
    
    private int findLonelyPixelConstantSpace(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        
        int ans = 0;
        for(int i=0;i<n;i++){
            if(picture[0][i] == 'B'){
                if(check(picture, 0, i)){
                    ans++;
                }else{
                    break;
                }
            }
        }
        
        for(int i=1;i<m;i++){
            if(picture[i][0] == 'B'){
                if(check(picture, i, 0)){
                    ans++;
                }else{
                    break;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            picture[0][i] = picture[0][i]=='B' ? '1' : '0';
        }
        
        for(int i=0;i<m;i++){
            picture[i][0] = picture[i][0]=='B' ? '1' : '0';
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(picture[i][j]=='B'){
                    picture[i][0]++;
                    picture[0][j]++;
                }
            }
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(picture[i][j]=='B' && picture[i][0]=='1' && picture[0][j]=='1'){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    // Returns true if the cell at (x, y) is lonely.
    // There should not be any other black cell 
    // In the first row and column except (x, y) itself.
    private boolean check(char[][] picture, int x, int y) {
        int n = picture.length;
        int m = picture[0].length;
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (picture[i][y] == 'B' ? 1 : 0);
        }
        
        for (int j = 0; j < m; j++) {
            // avoid double count (x, y)
            if (j != y) cnt += (picture[x][j] == 'B' ? 1 : 0);
        }
        return cnt == 1;
    }
    
    private int findLonelyPixelLinearSpace(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        //Get the row and column counts for B pixel
        //for a B pixel at row i and column j then increment rows[i] and cols[i] count by 1.
        for(int i=0;i<m;i++){
            int bCnt = 0;
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        
        //Iterate over the picture, for each black pixel at row i and column j
        //check if row i and col j both have only one B pixel or not.
        //If yes then this is the lonely pixel.
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B' && rows[i]==1 && cols[j]==1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}