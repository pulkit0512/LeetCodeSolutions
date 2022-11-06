class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    
    char[][] board;
    List<String> ans;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word:words) {
            int len = word.length();
            TrieNode node = root;
            for(int i=0;i<len;i++){
                char ch = word.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.word = word;
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.children[board[i][j]-'a']!=null){
                    backtrack(i, j, root);
                }
            }
        }
        
        return ans;
    }
    
    private void backtrack(int row, int col, TrieNode root) {
        char ch = board[row][col];
        TrieNode curNode = root.children[ch-'a'];
        
        if(curNode.word!=null){
            ans.add(curNode.word);
            // Remove the word, to avoid duplicate results.
            curNode.word = null;
        }
        
        board[row][col] = '0';
        
        for(int i=0;i<4;i++){
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if(newRow>=0 && newCol>=0 && newRow<board.length && newCol<board[0].length
              && board[newRow][newCol]!='0' && curNode.children[board[newRow][newCol]-'a']!=null) {
                backtrack(newRow, newCol, curNode);
            }
        }
        
        // backtrack
        board[row][col] = ch;
        
        // if curNode is leaf, remove it reduce search space for future.
        boolean hasChildren = false;
        for(int i=0;i<26;i++){
            if(curNode.children[i]!=null){
                hasChildren = true;
                break;
            }
        }
        
        if(!hasChildren) {
            root.children[ch-'a'] = null;
        }
    }
}