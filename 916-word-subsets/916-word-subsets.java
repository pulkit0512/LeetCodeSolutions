class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        for(String word:words2){
            int[] cur = new int[26];
            int len = word.length();
            for(int i=0;i<len;i++){
                cur[word.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                freq[i] = Math.max(freq[i], cur[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(String word:words1){
            int[] arr = new int[26];
            for(int i=0;i<26;i++){
                arr[i] = freq[i];
            }
            int len = word.length();
            for(int i=0;i<len;i++){
                arr[word.charAt(i)-'a']--;
            }
            boolean match = true;
            for(int i=0;i<26;i++){
                if(arr[i]>0){
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