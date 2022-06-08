class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len==1){
            return 1;
        }
        int dp[][] = new int[len][len];
        for(int gap=0;gap<len;gap++){
            for(int i=0, j=gap;j<len;i++,j++){
                if(gap==0){
                    dp[i][j]=1;
                } else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}