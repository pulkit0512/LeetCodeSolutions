## Approach:
* For each node find the left and right height.
* Diameter will be max of existing diamter or left + right height of current node.
* Height from this node will max of left or right height + 1.
​
### Time Complexity: O(N)
### Space Complexity: O(N), for unbalanced tree and O(LogN) for balanced tree.