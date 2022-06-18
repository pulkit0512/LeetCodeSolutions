## Approach:
* In this approach, created prefix and suffix tries and at each node I am having a linked hashset which will store indexes of words at this node.
* In prefix trie for a word at each node i am adding it's index indicating upto this node current word has prefix.
* Similarly created a suffix trie.
* Once done with in the constructed, in the query part I am creating a cache if same query is made again return answer from cache.
* Else get the all the indexes with current prefix and all the indexes with current suffix from both tries check if a index present in both if yes store it in answer.
* return the largest index.
​
### Time Complexity: O(NK + QK), where N is number words, Q is number of queries and K is maximum length of word.
​
### Space Complexity: O(NK + Q) for trie and cache.