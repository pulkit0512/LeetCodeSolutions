class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Map<String, Integer> lenMap = new HashMap<>();
        int dp[] = new int[n];
        int max = 1;
        for(int i=0;i<n;i++){
            lenMap.put(words[i], words[i].length());
            dp[i] = 1;
        }
        Arrays.sort(words, (a,b) -> (lenMap.get(a)-lenMap.get(b)));
        for(int i=1;i<n;i++){
            int lenS = lenMap.get(words[i]);
            for(int j=i-1;j>=0;j--){
                int lenT = lenMap.get(words[j]);
                if(lenS>lenT+1){
                    break;
                }
                if(lenS==lenT+1){
                    if(isChain(words[i], words[j], lenS)){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    private boolean isChain(String s, String t, int len) {
        int mc = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)==t.charAt(mc)){
                mc++;
            }
            if(mc==len-1){
                return true;
            }
        }
        return false;
    }
}