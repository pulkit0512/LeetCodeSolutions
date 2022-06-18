class WordFilter {
    class TrieNode{
        Map<Character, TrieNode> children;
        Set<Integer> wordSet;
        public TrieNode() {
            children = new HashMap<>();
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
            TrieNode node = preTrie;
            for(int j=0;j<len;j++){
                if(!node.children.containsKey(words[i].charAt(j))){
                    node.children.put(words[i].charAt(j), new TrieNode());
                }
                TrieNode preNode = node.children.get(words[i].charAt(j));
                preNode.wordSet.add(i);
                node = preNode;
            }
            node = sufTrie;
            for(int j=len-1;j>=0;j--){
                if(!node.children.containsKey(words[i].charAt(j))){
                    node.children.put(words[i].charAt(j), new TrieNode());
                }
                TrieNode sufNode = node.children.get(words[i].charAt(j));
                sufNode.wordSet.add(i);
                node = sufNode;
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        if(cache.containsKey(prefix+"_"+suffix)){
            return cache.get(prefix+"_"+suffix);
        }
        int preLen = prefix.length();
        int sufLen = suffix.length();
        TrieNode preNode = preTrie, sufNode = sufTrie;
        int i = 0;
        for(;i<preLen;i++){
            if(!preNode.children.containsKey(prefix.charAt(i))){
                return -1;
            }
            preNode = preNode.children.get(prefix.charAt(i));
        }
        i = sufLen-1;
        for(;i>=0;i--){
            if(!sufNode.children.containsKey(suffix.charAt(i))){
                return -1;
            }
            sufNode = sufNode.children.get(suffix.charAt(i));
        }
        int ans = -1, maxLen = 0;
        for(int x:preNode.wordSet){
            if(sufNode.wordSet.contains(x)){
                ans = x;
            }
        }
        cache.put(prefix+"_"+suffix, ans);
        return ans;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */