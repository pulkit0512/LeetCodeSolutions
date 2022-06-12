class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(int i=0;i<len;i++){
            for(String word:wordDict) {
                int wLen = word.length();
                if(i>=(wLen-1) && (i==wLen-1 || dp[i-wLen])) {
                    if(s.substring(i-wLen+1, i+1).equals(word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[len-1];
    }
}