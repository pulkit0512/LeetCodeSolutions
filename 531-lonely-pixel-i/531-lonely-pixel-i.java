class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] columnMap = new int[n];
        for(int i=0;i<m;i++){
            int bCnt = 0;
            List<Integer> col = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    bCnt++;
                    col.add(j);
                }
            }
            
            if(bCnt==1){
                columnMap[col.get(0)]++;
            }else {
                for(int c:col){
                    columnMap[c] = 1000;
                }
            }
        }
        
        int ans = 0;
        for(int colCnt:columnMap){
            if(colCnt==1){
                ans++;
            }
        }
        return ans;
    }
}