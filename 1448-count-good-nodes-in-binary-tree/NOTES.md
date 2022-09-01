## Approach: DFS/BFS
* For each node in the DFS recursion we will also pass the max till now.
* If maxTill now is less or equal to current node val then this node is a good node.
* For child calls update the max and make the recursive calls.
​
### Time Complexity: O(N)
### Space Complexity: O(N)