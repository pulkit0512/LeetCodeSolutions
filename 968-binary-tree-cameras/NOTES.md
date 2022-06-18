## Approach: Greedy
* In this approach, try to cover nodes in bottom up direction. We will have track of covered nodes in a set. If a node has it's children covered and has a parent then it's better to place the camera at this node's parent.
* If node has children that are not covered by a camera then we must place a camera at current node.
* Also if a node has no parent and it is not covered yet then place camera at that node as well.
​
### Time & Space Complexity: O(N), N is number of nodes.