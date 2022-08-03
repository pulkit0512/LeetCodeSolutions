## Approach1: DFS to check if subtree complete or not
* For each node, check if subtree whose root is current node is complete or not. If it is complete we don't need to traverse all the nodes in that substree. And number of nodes in complete tree is 2^height - 1.
* If subtree is not complete, we need to move to left and right child's to count the nodes in similar way.
​
### Time Complexity: Less then O(N) on average.
### Space Complexity: O(LogN)
​
## Approach2: Binary Search on last level
* Return 0 if the tree is empty.
* Compute the tree depth d.
* Return 1 if d == 0.
* The number of nodes in all levels but the last one is 2^d - 1. The number of nodes in the last level could vary from 1 to 2^d. Enumerate potential nodes from 0 to 2^d - 1 and perform the binary search by the node index to check how many nodes are in the last level. Use the function exists(idx, d, root) to check if the node with index idx exists.
* Use binary search to implement exists(idx, d, root) as well.
* Return 2^d - 1 + the number of nodes in the last level.
​
### Time Complexity: O(logN x logN)
### Space Complexity: O(1)