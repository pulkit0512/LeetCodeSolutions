## Approach:
* Calculate height of each child of a node. And keep track of max & secMax of children heights.
* Diameter will be max of existing diameter stored in global variable or sum of max & secMax heights.
* return height of current node which is max + 1.
​
### Time Complexity: O(N)
### Space Complexity: O(N)