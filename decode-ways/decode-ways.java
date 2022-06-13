class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=1;i<len;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'){
                    return 0;
                }
                if(s.charAt(i-1)<='2'){
                    dp[i+1] += dp[i-1];
                }
            }else{
                dp[i+1] += dp[i];
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[len];
    }
}