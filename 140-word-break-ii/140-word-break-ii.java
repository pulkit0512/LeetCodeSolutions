class Solution {
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        List<String>[] dp = new ArrayList[len+1];
        Set<String> wordSet = new HashSet<>(wordDict);
        for(int i=0;i<=len;i++){
            dp[i] = new ArrayList<>();
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                String subStr = s.substring(i, j);
                if(wordSet.contains(subStr)){
                    dp[j].add(subStr);
                }
            }
        }
        result = new ArrayList<>();
        if(dp[len].isEmpty()){
            return result;
        }
        
        wordBreakUtil(dp, len, "");
        return result;
    }
    
    private void wordBreakUtil(List<String>[] dp, int len, String sentence) {
        if(len==0){
            result.add(sentence.trim());
            return;
        }
        if(len<0){
            return;
        }
        for(String word:dp[len]) {
            wordBreakUtil(dp, len-word.length(), word +" "+sentence);
        }
    }
}