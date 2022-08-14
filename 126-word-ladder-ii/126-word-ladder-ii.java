class Solution {
    List<List<String>> ladders;
    List<String> ladder;
    Map<String, List<String>> graph;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        graph = new HashMap<>();
        ladders = new ArrayList<>();
        ladder = new ArrayList<>();
        
        // Create copy of wordList into a set for fast operations.
        Set<String> wordSet = new HashSet<>(wordList);
        
        // BFS to create a DAG: Neighbour -> CurWord
        bfs(beginWord, endWord, wordSet);
        
        // Move from endWord to beginWord, since we created a DAG from neighbour -> curWord
        // Add endWord to the list since all accepted ladders will have endWord in them
        ladder.add(endWord);
        
        // backtrack on the DAG to get all the ladders
        backtrack(endWord, beginWord);
        
        return ladders;
    }
    
    private void backtrack(String start, String end) {
        if(start.equals(end)){
            List<String> curLadder = new ArrayList<>(ladder);
            Collections.reverse(curLadder);
            ladders.add(curLadder);
            return;
        }
        if(!graph.containsKey(start)){
            return;
        }
        for(String word:graph.get(start)){
            ladder.add(word);
            backtrack(word, end);
            ladder.remove(ladder.size()-1);
        }
    }
    
    private void bfs(String start, String end, Set<String> wordSet) {
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        que.add(start);
        wordSet.remove(start);
        
        while(!que.isEmpty()){
            List<String> curLayer = new ArrayList<>();
            for(int i=que.size()-1;i>=0;i--){
                String curWord = que.poll();
                List<String> nbours = getNeighbours(curWord, wordSet);
                for(String nbour:nbours){
                    curLayer.add(nbour);
                    if(!graph.containsKey(nbour)){
                        graph.put(nbour, new ArrayList<>());
                    }
                    
                    // Add edge from nbour to curWord
                    graph.get(nbour).add(curWord);
                    
                    if(!visited.contains(nbour)){
                        que.add(nbour);
                        visited.add(nbour);
                    }
                }
            }
            for(String cur:curLayer){
                wordSet.remove(cur);
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
                if(arr[i]==cur || !wordSet.contains(newWord)){
                    continue;
                }
                nbours.add(newWord);
            }
            arr[i] = cur;
        }
        return nbours;
    }
}