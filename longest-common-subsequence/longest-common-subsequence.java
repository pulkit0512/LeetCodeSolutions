class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //return lcsN2Space(text1, text2);
        return lcsNSpace(text1, text2);
    }
    
    private int lcsNSpace(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int prev[] = new int[m+1];
        int curr[] = new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j] = prev[j-1] + 1;
                }else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            for(int j=1;j<=m;j++){
                prev[j] = curr[j];
            }
        }
        return prev[m];
    }
    
    private int lcsN2Space(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}