class Trie {
    class TrieNode {
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[27];
        }
    }
    
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0;i<len;i++){
            if(node.children[word.charAt(i)-'a']==null){
                node.children[word.charAt(i)-'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i)-'a'];
        }
        node.children[26] = new TrieNode();
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0;i<len;i++){
            if(node.children[word.charAt(i)-'a']==null){
                return false;
            }
            node = node.children[word.charAt(i)-'a'];
        }
        if(node.children[26]==null){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        for(int i=0;i<len;i++){
            if(node.children[prefix.charAt(i)-'a']==null){
                return false;
            }
            node = node.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */