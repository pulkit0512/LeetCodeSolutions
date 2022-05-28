class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int val1 = -1, val2 = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                if(val2!=-1){
                    ans = Math.min(ans, i-val2);
                }
                val1 = i;
            }else if(wordsDict[i].equals(word2)){
                if(val1!=-1){
                    ans = Math.min(ans, i-val1);
                }
                val2 = i;
            }
        }
        return ans;
    }
}