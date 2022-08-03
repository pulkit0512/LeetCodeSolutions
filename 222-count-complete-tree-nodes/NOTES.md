## Approach: DFS to check if subtree complete or not
* For each node, check if subtree whose root is current node is complete or not. If it is complete we don't need to traverse all the nodes in that substree. And number of nodes in complete tree is 2^height - 1.
* If subtree is not complete, we need to move to left and right child's to count the nodes in similar way.
​
### Time Complexity: Less then O(N) on average.
### Space Complexity: O(LogN)