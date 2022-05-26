## Approach: DFS+Backtracking
* In this question, I have used DFS and Backtracking. First in the entire board I try to find the cell which is equal to first char of the word. Then set this cell in board to empty char and make a call to helper function board, i, j, word and index to be processed next. Then if we found a word return true else false.
* In helper function try to find the char to be next processed in the neighbours, if found set this char to empty char and make recursive call for next char. else set this char back to original value.
​
### Complexity Analysis
​
* **Time Complexity: O(N⋅3^L)** where N is the number of cells in the board and L is the length of the word to be matched.
* For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L3.
* We iterate through the board for backtracking, i.e. there could be N times invocation for the backtracking function in the worst case.
* As a result, overall the time complexity of the algorithm would be O(N⋅3^L).
​
* **Space Complexity: O(L) where L is the length of the word to be matched.**
* The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is O(L).