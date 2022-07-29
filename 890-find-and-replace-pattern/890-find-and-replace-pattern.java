class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int pLen = pattern.length();
        char[] mapping = new char[26];
        for(String word:words) {
            Arrays.fill(mapping, '0');
            boolean match = true;
            for(int i=0;i<pLen;i++){
                int idx = pattern.charAt(i)-'a';
                if(mapping[idx]=='0'){
                    mapping[idx] = word.charAt(i);
                }else if(mapping[idx] != word.charAt(i)){
                    match = false;
                    break;
                }
            }
            int freq[] = new int[26];
            for(int i=0;i<26;i++){
                if(mapping[i]=='0'){
                    continue;
                }
                freq[mapping[i]-'a']++;
                if(freq[mapping[i]-'a']>1){
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