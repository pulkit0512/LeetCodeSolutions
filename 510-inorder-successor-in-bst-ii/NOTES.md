## Algorithm
* If the node has a right child, and hence its successor is somewhere lower in the tree. Go to the right once and then as many times to the left as you could. Return the node you end up with.
* Node has no right child, and hence its successor is somewhere upper in the tree. Go up till the node that is left child of its parent. The answer is the parent.
​
### Time Complexity: O(H), H is height of tree. O(Log(N)) in average case and O(N) in worst case for skewed tree.
### Space Complexity: O(1)