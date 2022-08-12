class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        int len = word.length();
        for(int i=0;i<len;i++){
            if(node.children[word.charAt(i)-'a']==null){
                node.children[word.charAt(i)-'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i)-'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode node = root;
        return dfs(word, 0, len, node);
    }
    
    private boolean dfs(String word, int idx, int len, TrieNode node) {
        if(idx==len){
            return node.isWord;
        }
        if(word.charAt(idx)=='.'){
            TrieNode temp = node;
            for(int i=0;i<26;i++){
                if(node.children[i]!=null){
                    node = node.children[i];
                    if(dfs(word, idx+1, len, node)){
                        return true;
                    }
                    node = temp;
                }
            }
        }else if(node.children[word.charAt(idx)-'a']==null){
            return false;
        }else{
            node = node.children[word.charAt(idx)-'a'];
            if(dfs(word, idx+1, len, node)){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */