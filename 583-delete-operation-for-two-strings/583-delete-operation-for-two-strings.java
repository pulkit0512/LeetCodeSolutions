class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int lcs;
        if(len1>=len2){
            lcs = getLcsLength(word1, word2, len1, len2);
        }else{
            lcs = getLcsLength(word2, word1, len2, len1);
        }
        return len1 + len2 - 2*lcs;
    }
    
    private int getLcsLength(String s, String t, int sLen, int tLen) {
        int prev[] = new int[tLen+1];
        int curr[] = new int[tLen+1];
        for(int i=1;i<=sLen;i++){
            for(int j=1;j<=tLen;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = prev[j-1] + 1;
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            for(int j=1;j<=tLen;j++){
                prev[j] = curr[j];
                //System.out.print(prev[j]+" ");
            }
            //System.out.println();
        }
        return prev[tLen];
    }
}