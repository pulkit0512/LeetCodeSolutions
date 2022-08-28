## Approach:
* For each node find the longest increasing path and longest decreasing path.
* Make calls to left and right child of a node, if node null return {0,0}.
* If node has a left child, then if it is making any increasing or decreasing path with current node then set increment and decrement lengths of current node.
* Similarly check for the right child.
* longestPath will be max of longestPath till now or path from current node which inr+dcr-1.
* return {inr, dcr}.
​
### Time Complexity: O(N)
### Space Complexity: O(N)