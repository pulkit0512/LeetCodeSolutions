class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        List<String>[] dp = new ArrayList[len+1];
        dp[0] = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(dp[i]!=null){
                for(int j=i+1;j<=len;j++){
                    String sub = s.substring(i,j);
                    if(wordSet.contains(sub)){
                        if(dp[j]==null){
                            dp[j] = new ArrayList<>();
                        }
                        dp[j].add(sub);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if(dp[len]==null){
            return ans;
        }
        wordBreakUtil(dp, len, "");
        return ans;
    }
    
    private void wordBreakUtil(List<String>[] dp, int idx, String psf) {
        if(idx==0){
            ans.add(psf.trim());
            return;
        }
        for(String x:dp[idx]){
            wordBreakUtil(dp, idx-x.length(), x+" "+psf);
        }
    }
}