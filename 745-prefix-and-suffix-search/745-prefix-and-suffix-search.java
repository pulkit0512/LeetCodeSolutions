class WordFilter {
    class TrieNode{
        TrieNode[] children;
        Set<Integer> wordSet;
        public TrieNode() {
            children = new TrieNode[26];
            wordSet = new LinkedHashSet<>();
        }
    }
    TrieNode preTrie, sufTrie;
    String[] words;
    Map<String, Integer> cache;
    public WordFilter(String[] words) {
        this.words = words;
        this.cache = new HashMap<>();
        preTrie = new TrieNode();
        sufTrie = new TrieNode();
        for(int i=0;i<words.length;i++){
            int len = words[i].length();
            TrieNode node1 = preTrie;
            TrieNode node2 = sufTrie;
            for(int j=0;j<len;j++){
                if(node1.children[words[i].charAt(j)-'a']==null){
                    node1.children[words[i].charAt(j)-'a'] = new TrieNode();
                }
                TrieNode preNode = node1.children[words[i].charAt(j)-'a'];
                preNode.wordSet.add(i);
                node1 = preNode;
                
                if(node2.children[words[i].charAt(len-1-j)-'a']==null){
                    node2.children[words[i].charAt(len-1-j)-'a'] = new TrieNode();
                }
                TrieNode sufNode = node2.children[words[i].charAt(len-1-j)-'a'];
                sufNode.wordSet.add(i);
                node2 = sufNode;
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String key = prefix+"_"+suffix;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int preLen = prefix.length();
        int sufLen = suffix.length();
        TrieNode preNode = preTrie, sufNode = sufTrie;
        int i = 0;
        for(;i<preLen;i++){
            if(preNode.children[prefix.charAt(i)-'a']==null){
                return -1;
            }
            preNode = preNode.children[prefix.charAt(i)-'a'];
        }
        i = sufLen-1;
        for(;i>=0;i--){
            if(sufNode.children[suffix.charAt(i)-'a']==null){
                return -1;
            }
            sufNode = sufNode.children[suffix.charAt(i)-'a'];
        }
        int ans = -1;
        for(int x:preNode.wordSet){
            if(sufNode.wordSet.contains(x)){
                ans = x;
            }
        }
        cache.put(key, ans);
        return ans;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */