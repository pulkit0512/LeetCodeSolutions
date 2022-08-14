class Solution {
    List<List<String>> ladders;
    List<String> ladder;
    Map<String, List<String>> graph;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        graph = new HashMap<>();
        ladders = new ArrayList<>();
        ladder = new ArrayList<>();
        
        // Create set of words from input wordList
        Set<String> wordSet = new HashSet<>(wordList);
        
        // Create a DAG using BFS
        bfs(beginWord, endWord, wordSet);
        
        // Backtrack the graph created in above step to get all the ladders
        backtrack(endWord, beginWord);
        
        return ladders;
    }
    
    private void backtrack(String start, String end) {
        ladder.add(start);
        if(start.equals(end)){
            List<String> curLadder = new ArrayList<>(ladder);
            Collections.reverse(curLadder);
            ladders.add(curLadder);
            ladder.remove(ladder.size()-1);
            return;
        }
        if(!graph.containsKey(start)){
            return;
        }
        for(String word:graph.get(start)){
            backtrack(word, end);
        }
        ladder.remove(ladder.size()-1);
    }
    
    private void bfs(String start, String end, Set<String> wordSet) {
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.add(start);
        
        if(wordSet.contains(start)){
            wordSet.remove(start);
        }
        
        while(!que.isEmpty()) {
            List<String> curSet = new ArrayList<>();
            for(int i=que.size()-1;i>=0;i--){
                String curWord = que.poll();
                List<String> nbours = getNeighbours(curWord, wordSet);
                for(String nbour:nbours) {
                    curSet.add(nbour);
                    if(!graph.containsKey(nbour)){
                        graph.put(nbour, new ArrayList<>());
                    }
                    
                    // add the edge from word to curWord
                    graph.get(nbour).add(curWord);
                    
                    if(!visited.contains(nbour)){
                        que.add(nbour);
                        visited.add(nbour);
                    }
                }
            }
            
            for(String word:curSet) {
                wordSet.remove(word);
            }
        }
    }
    
    private List<String> getNeighbours(String curWord, Set<String> wordSet) {
        List<String> nbours = new ArrayList<>();
        char[] arr = curWord.toCharArray();
        for(int i=0;i<arr.length;i++){
            char cur = arr[i];
            for(char ch='a';ch<='z';ch++){
                arr[i] = ch;
                String newWord = String.valueOf(arr);
                if(ch==cur || !wordSet.contains(newWord)){
                    continue;
                }
                nbours.add(newWord);
            }
            arr[i] = cur;
        }
        return nbours;
    }
}