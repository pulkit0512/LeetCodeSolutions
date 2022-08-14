## Approach: BFS + DFS
* Store the words present in wordList in an unordered set so that the words can be efficiently removed during the breadth-first search.
* Perform the BFS to create a DAG, and add the directed edges from neighbours to current word. Edge is created this way because in backtracking we move from endWord to startWord. Also once a level is finished remove the visited words from the wordSet.
* Start from endWord and while keep tracking of the current path as currPath traverse all the possible paths, whenever the path leads to the startWord, store the reversed path in shortestPaths.
​
### Time Complexity: O(N x K x K + P), N = number of words, K = maximum length of word, P = number of possible paths from begin word to end word.
### Space Complexity: O(NK)