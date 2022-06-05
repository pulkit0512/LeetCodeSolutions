class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = -1, idx2 = -1;
        int ans = Integer.MAX_VALUE;
        boolean equal = word1.equals(word2);
        for(int i=0;i<wordsDict.length;i++){
            if(word1.equals(wordsDict[i])){
                if(idx2!=-1){
                    ans = Math.min(ans, i-idx2);
                }else if(equal && idx1!=-1){
                    ans = Math.min(ans, i-idx1);
                }
                idx1 = i;
            }else if(word2.equals(wordsDict[i])){
                if(idx1!=-1){
                    ans = Math.min(ans, i-idx1);
                }
                idx2 = i;
            }
        }
        return ans;
    }
}