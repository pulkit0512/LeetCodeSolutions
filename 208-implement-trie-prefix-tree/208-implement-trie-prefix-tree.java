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
            char ch = word.charAt(i);
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.children[26] = new TrieNode();
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        for(int i=0;i<len;i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.children[26]!=null;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode node = root;
        for(int i=0;i<len;i++){
            char ch = prefix.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }
            node = node.children[ch-'a'];
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