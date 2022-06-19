class Solution {
    class Pair{
        int len;
        int val;
        public Pair(int a, int b){
            len = a;
            val = b;
        }
    }
    public int longestSubsequence(String s, int k) {
        int len = s.length();
        Pair[] dp = new Pair[len];
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='0'){
                dp[i] = new Pair(1, 0);
            }else{
                dp[i] = new Pair(1, 1);
            }
        }
        int res = 0;
        for(int i=len-1;i>=0;i--){
            char ch = s.charAt(i);
            for(int j=i+1;j<len;j++){
                int curVal = dp[j].val;
                if(ch=='0' && curVal<=k){
                    dp[i].len = Math.max(dp[i].len, dp[j].len + 1);
                    dp[i].val = curVal;
                }else{
                    if(dp[j].len<31){
                        int pow = (1<<dp[j].len);
                        if(curVal + pow <= k && dp[i].len<dp[j].len+1){
                            dp[i].len = dp[j].len + 1;
                            dp[i].val = curVal + pow;
                        }
                    }
                }
                if(dp[i].len>res){
                    break;
                }
            }
            res = Math.max(res, dp[i].len);
        }
        return res;
    }
}