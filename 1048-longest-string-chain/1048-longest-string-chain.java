class Solution {
    class Pair{
        String word;
        int len;
        public Pair(String a, int b){
            word = a;
            len = b;
        }
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Pair[] wordsPair = new Pair[n];
        int dp[] = new int[n];
        int max = 1;
        for(int i=0;i<n;i++){
            wordsPair[i] = new Pair(words[i], words[i].length());
            dp[i] = 1;
        }
        Arrays.sort(wordsPair, (a,b) -> (a.len-b.len));
        for(int i=1;i<n;i++){
            int lenS = wordsPair[i].len;
            for(int j=i-1;j>=0;j--){
                int lenT = wordsPair[j].len;
                if(lenS>lenT+1){
                    break;
                }
                if(lenS==lenT+1){
                    if(isChain(wordsPair[i].word, wordsPair[j].word, lenS)){
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