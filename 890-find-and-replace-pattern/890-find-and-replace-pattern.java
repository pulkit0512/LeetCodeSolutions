class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int pLen = pattern.length();
        char[] patMap = new char[26];
        char[] wordMap = new char[26];
        for(String word:words) {
            for(int i=0;i<26;i++){
                patMap[i] = '0';
                wordMap[i] = '0';
            }
            boolean match = true;
            for(int i=0;i<pLen;i++){
                int pIdx = pattern.charAt(i)-'a';
                int wIdx = word.charAt(i)-'a';
                if(patMap[pIdx]=='0'){
                    patMap[pIdx] = word.charAt(i);
                }else if(patMap[pIdx] != word.charAt(i)){
                    match = false;
                    break;
                }
                
                if(wordMap[wIdx] == '0'){
                    wordMap[wIdx] = pattern.charAt(i);
                }else if(wordMap[wIdx] != pattern.charAt(i)){
                    match = false;
                    break;
                }
            }
            if(match){
                result.add(word);
            }
        }
        return result;
    }
}