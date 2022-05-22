class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int ans = 0;
        for(int gap=0;gap<len;gap++){
            for(int i=0,j=gap;i<len && j<len;i++,j++){
                if(gap==0){
                    dp[i][j] = true;
                    ans++;
                }else if(s.charAt(i)==s.charAt(j)){
                    if(gap==1){
                        dp[i][j] = true;
                        ans++;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}