class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[0] = true;
        for(int i=1;i<=len;i++){
            for(String word:wordDict){
                int wLen = word.length();
                if(i>=wLen && (i==wLen || dp[i-wLen])){
                    if(s.substring(i-wLen, i).equals(word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[len];
    }
    
    /*
    //Using set index of prev substring start that are in wordDict
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<Integer> index = new ArrayList<>();
        int st = 0;
        int len = s.length();
        for(int i=1;i<=len;i++){
            String sub = s.substring(st, i);
            if(wordSet.contains(sub)){
                index.add(st);
                st = i;
            }else{
                for(int j=0;j<index.size();j++){
                    if(wordSet.contains(s.substring(index.get(j), i))){
                        index.add(st);
                        st = i;
                        break;
                    }
                }
            }
        }
        return st==len;
    }
    */
}