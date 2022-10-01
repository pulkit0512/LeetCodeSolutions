class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        
        for(int i=0;i<m;i++){
            int bCnt = 0;
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    bCnt++;
                    
                    if(bCnt>1){
                        break;
                    }
                }
            }
            
            if(bCnt==1){
                rows[i] = true;
            }
        }
        
        for(int i=0;i<n;i++){
            int bCnt = 0;
            for(int j=0;j<m;j++){
                if(picture[j][i]=='B'){
                    bCnt++;
                    
                    if(bCnt>1){
                        break;
                    }
                }
            }
            
            if(bCnt==1){
                cols[i] = true;
            }
        }
        
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B' && rows[i] && cols[j]){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}