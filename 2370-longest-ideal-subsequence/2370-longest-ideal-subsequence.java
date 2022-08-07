class Solution {
    public int longestIdealString(String s, int k) {
        int len = s.length();
        int dp[] = new int[26];
        int ans = 0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            int curLen = 0;
            for(int j=0;j<26;j++){
                if(Math.abs(j-(ch-'a'))<=k){
                    curLen = Math.max(curLen, dp[j]);
                }
            }
            dp[ch-'a'] = curLen+1;
            ans = Math.max(ans, curLen+1);
        }
        return ans;
    }
}