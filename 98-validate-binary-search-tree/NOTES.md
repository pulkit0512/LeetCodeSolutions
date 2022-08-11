## Approach:
To validate Binary tree is a BST or not, for each node we will send the range of values a node can have. If node value is outside the range return false. Else we will check same for left and right subtrees by modifying the range accordingly.
​
### Time Complexity: O(N)
### Space Complexity: O(N)