class Solution {
    class TrieNode{
        TrieNode[] children;
        int count;
        public TrieNode(){
            children = new TrieNode[26];
            count = 0;
        }
    }
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<Integer>> groups = new HashMap<>();
        int n = words.size();
        String ans[] = new String[n];
        for(int i=0;i<n;i++){
            ans[i] = abrev(words.get(i), 0);
            if(!groups.containsKey(ans[i])){
                groups.put(ans[i], new ArrayList<>());
            }
            groups.get(ans[i]).add(i);
        }
        for(List<Integer> group:groups.values()){
            TrieNode root = new TrieNode();
            for(int x:group){
                TrieNode cur = root;
                int len = words.get(x).length();
                for(int i=0;i<len;i++){
                    if(cur.children[words.get(x).charAt(i)-'a']==null){
                        cur.children[words.get(x).charAt(i)-'a'] = new TrieNode();
                    }
                    cur = cur.children[words.get(x).charAt(i)-'a'];
                    cur.count++;
                }
            }
            
            for(int x:group){
                TrieNode cur = root;
                int len = words.get(x).length();
                int i = 0;
                for(;i<len;i++){
                    if(cur.count==1){
                        break;
                    }
                    cur = cur.children[words.get(x).charAt(i)-'a'];
                }
                ans[x] = abrev(words.get(x), i-1);
            }
        }
        return Arrays.asList(ans);
    }
    
    private String abrev(String word, int i){
        int len = word.length();
        if(len-i<=3){
            return word;
        }
        return word.substring(0,i+1) + (len-i-2) + word.charAt(len-1);
    }
}