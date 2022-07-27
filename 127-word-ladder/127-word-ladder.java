class Solution {
    class WordNode {
        String word;
        int steps;
        
        public WordNode(String s, int a) {
            word = s;
            steps = a;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Queue<WordNode> que = new LinkedList<>();
        que.add(new WordNode(beginWord, 1));
        int ans = 0;
        while(!que.isEmpty()){
            WordNode cur = que.poll();
            if(cur.word.equals(endWord)){
                ans = cur.steps;
                break;
            }
            char[] arr = cur.word.toCharArray();
            for(int i=0;i<arr.length;i++){
                char x = arr[i];
                for(char ch='a';ch<='z';ch++) {
                    if(ch!=x){
                        arr[i] = ch;
                        String s = String.valueOf(arr);
                        if(wordSet.contains(s)){
                            que.add(new WordNode(s, cur.steps + 1));
                            wordSet.remove(s);
                        }
                    }
                }
                arr[i] = x;
            }
        }
        return ans;
    }
}