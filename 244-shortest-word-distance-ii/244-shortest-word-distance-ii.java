class WordDistance {

    Map<String, List<Integer>> words;
    public WordDistance(String[] wordsDict) {
        words = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            if(!words.containsKey(wordsDict[i])){
                words.put(wordsDict[i], new ArrayList<>());
            }
            words.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int idx1 = 0, idx2 = 0;
        int ans = Integer.MAX_VALUE;
        while(idx1<words.get(word1).size() && idx2<words.get(word2).size()) {
            int val1 = words.get(word1).get(idx1);
            int val2 = words.get(word2).get(idx2);
            
            ans = Math.min(ans, Math.abs(val1-val2));
            if(val1<val2){
                idx1++;
            }else {
                idx2++;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */