class Solution {
    class TrieNode{
        TrieNode[] children;
        List<String> words;
        public TrieNode(){
            children = new TrieNode[26];
            words = new ArrayList<>();
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        for(String product:products){
            int len = product.length();
            TrieNode node = root;
            for(int i=0;i<len;i++){
                int idx = product.charAt(i)-'a';
                if(node.children[idx]==null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.words.add(product);
            }
        }
        List<List<String>> res = new ArrayList<>();
        int len = searchWord.length();
        for(int i=0;i<len;i++){
            List<String> list = new ArrayList<>();
            int idx = searchWord.charAt(i)-'a';
            if(root==null){
                res.add(list);
                continue;
            }
            if(root.children[idx]==null){
                res.add(list);
                root = root.children[idx];
                continue;
            }
            for(int j=0;j<Math.min(3, root.children[idx].words.size());j++){
                list.add(root.children[idx].words.get(j));
            }
            res.add(list);
            root = root.children[idx];
        }
        return res;
    }
}