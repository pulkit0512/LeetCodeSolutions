## Approach1: Greedy O(1) Space
* If current node has left child, find rightmost node of left child let say this node x.
* Right child of x will be right child of current node.
* Current node left child will become it's right child
* Current node left will become null.
* Move to right of current node.
​
### Time Complexity: O(2N)
### Space Complexity: O(1)
​
## Approach2: Recursion
* In this approach, try to find the left and right tail for a current node.
* If current node is leaf return the node.
* If leftTail not null, rewire the connections, leftTail.right will become node.right.
* node.left will become node.right and node.left will be null.
* Return the rightmost node as the tail in recursive calls.
​
### Time Complexity: O(N)
### Space Complexity: O(N), recursive stack