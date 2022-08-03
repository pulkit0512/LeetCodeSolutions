## Approach:
* From given words, create a trie where each node has 26 children and a string to indicate end of a particular word.
* Once the trie is ready. Iterate over the board, if any child of root is found make dfs call to see if this complete word starting with current char exist in board or not.
* In DFS call if we reached to a node which has word mapped, then that word will belong to answer list and now set node.word to null to avoid duplicate results.
* Set the current char as visited and check in the 4 neighbours any unvisited cell and a children of current node then make recursive call.
* Once done back track unmark current cell as visited.
* To reduce search space, if current node doesn't have any child then we can remove this from the children of it's parent node.
​
### Time Complexity: O(M(4 x 3^(L-1))), M = number of cells, L is maximum length of word. We have 4 possible paths and in each path we have atmost 3 neighbour cells to explore.
​
### Space Complexity: O(N), number of total letters in all the words. Since in word case we will have no overlapping prefixes and a copy of word in trie. So 2N letters.