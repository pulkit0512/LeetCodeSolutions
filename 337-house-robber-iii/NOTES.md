## Approach:
1. Followed post order tree traversal once reached to node we return the amount we can have either by including current or excluding it.
2. If including a node then it's include money will be it's value plus amount it got from exclude amount of it's child nodes.
3. If excluding a node then it's exclude money will be max(left.inc, left.ext) + max(right.inc, right.exc). I.e. sum of max we get by including or excluding left child plus max we get by including or excluding right child.
4. Return this include, exclude node money to parent node.
​
### Time Complexity: O(N) since each node is traversed once
### Space Complexity: O(N) recursion stack