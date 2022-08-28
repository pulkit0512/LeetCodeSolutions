class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int gap=0;gap<n;gap++){
            int cnt[] = new int[101];
            for(int row=0, col=gap; row<m && col<n; row++, col++){
                cnt[mat[row][col]]++;
            }
            int cur = 1;
            for(int row=0, col=gap; row<m && col<n; row++, col++){
                while(cnt[cur]==0){
                    cur++;
                }
                mat[row][col] = cur;
                cnt[cur]--;
            }
        }
        
        for(int gap=1;gap<m;gap++){
            int cnt[] = new int[101];
            for(int row=gap, col=0; row<m && col<n; row++, col++){
                cnt[mat[row][col]]++;
            }
            int cur = 1;
            for(int row=gap, col=0; row<m && col<n; row++, col++){
                while(cnt[cur]==0){
                    cur++;
                }
                mat[row][col] = cur;
                cnt[cur]--;
            }
        }
        
        return mat;
    }
}