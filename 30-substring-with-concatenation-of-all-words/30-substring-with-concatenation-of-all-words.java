class Solution {
    int wordLen;
    public List<Integer> findSubstring(String s, String[] words) {
        wordLen = words[0].length();
        int totalLen = words.length * wordLen;
        int len = s.length();
        List<Integer> result = new ArrayList<>();
        if(len<totalLen){
            return result;
        }
        
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word:words){
            wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
        }
        
        Map<Integer, String> subStrMap = new HashMap<>();
        for(int i=0;i<=len-wordLen;i++){
            subStrMap.put(i, s.substring(i, i+wordLen));
        }
        
        for(int i=0;i<wordLen;i++){
            int st = -1;
            int mc = 0;
            Map<String, Integer> freqMap = new HashMap<>();
            for(int j=i;j<=len-wordLen;j+=wordLen){
                String subStr = subStrMap.get(j);
                if(wordMap.containsKey(subStr)) {
                    int k = freqMap.getOrDefault(subStr, 0);
                    if(k==wordMap.get(subStr)){
                        while(!subStrMap.get(st).equals(subStr)){
                            st = removeExtraWordFromFreqMap(subStrMap, freqMap, st);
                            mc--;
                        }
                        freqMap.put(subStr, k-1);
                        st = st + wordLen;
                        mc--;
                    }
                    
                    freqMap.put(subStr, freqMap.getOrDefault(subStr, 0) + 1);
                    mc++;
                    if(st==-1) {
                        st = j;
                    }
                }else{
                    freqMap = new HashMap<>();
                    mc = 0;
                    st = -1;
                }
                
                if(mc==words.length){
                    result.add(st);
                    st = removeExtraWordFromFreqMap(subStrMap, freqMap, st);
                    mc--;
                }
            }
        }
        return result;
    }
    
    private int removeExtraWordFromFreqMap(Map<Integer, String> subStrMap, Map<String, Integer> freqMap, int st) {
        String curSubStr = subStrMap.get(st);
        int k = freqMap.get(curSubStr);
        if(k==1){
            freqMap.remove(curSubStr);
        }else{
            freqMap.put(curSubStr, k-1);
        }
        return st+wordLen;
    }
}