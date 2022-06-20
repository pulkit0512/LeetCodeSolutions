class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;
        
        public TrieNode(){
            children = new TrieNode[26];
            count = 0;
        }
    }
    public int minimumLengthEncoding(String[] words) {
        //return minimumLengthEncodingUsingSuffixMap(words);
        return minimumLengthEncodingUsingTrie(words);
    }
    
    private int minimumLengthEncodingUsingTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words){
            int len = word.length();
            TrieNode node = root;
            for(int i=len-1;i>=0;i--){
                char ch = word.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
                node.count++;
            }
        }
        int ans = 0;
        for(String word:words){
            int len = word.length();
            TrieNode node = root;
            for(int i=len-1;i>=0;i--){
                char ch = word.charAt(i);
                node = node.children[ch-'a'];
            }
            if(node.count==1){
                ans += len+1;
            }else{
                node.count--;
            }
        }
        return ans;
    }
    
    private int minimumLengthEncodingUsingSuffixMap(String[] words) {
        Map<String, Integer> suffixMap = new HashMap<>();
        for(int idx=0;idx<words.length;idx++){
            int len = words[idx].length();
            String s = "";
            for(int i=len-1;i>=0;i--){
                s += words[idx].charAt(i);
                suffixMap.put(s, suffixMap.getOrDefault(s, 0) + 1);
            }
            words[idx] = s;
        }
        //System.out.println(suffixMap);
        int len = 0;
        for(String word:words){
            if(suffixMap.get(word)==1){
                len += word.length()+1;
            }else{
                suffixMap.put(word, suffixMap.get(word)-1);
            }
        }
        return len;
    }
}