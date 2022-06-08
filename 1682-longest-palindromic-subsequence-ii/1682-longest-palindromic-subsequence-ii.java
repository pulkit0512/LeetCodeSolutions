class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len<=1){
            return 0;
        }
        int dp[][] = new int[len][len];
        char last[][] = new char[len][len];
        int ans = 0;
        for(int gap=1;gap<len;gap++){
            for(int i=0,j=gap;j<len;i++,j++){
                if(s.charAt(i)==s.charAt(j) && s.charAt(i)!=last[i+1][j-1]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    last[i][j] = s.charAt(i);
                }else{
                    if(dp[i][j-1]>=dp[i+1][j]){
                        dp[i][j] = dp[i][j-1];
                        last[i][j] = last[i][j-1];
                    }else{
                        dp[i][j] = dp[i+1][j];
                        last[i][j] = last[i+1][j];
                    }
                }
                if(dp[i][j]%2==0){
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}