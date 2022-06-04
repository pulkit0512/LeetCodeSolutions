## Approach: Using Validate BST
At Each preorder call checked if current value exist in limits or not. If not return null else create the node and call the left and right child with updated limits.
​
### Complexity Analysis
​
Time complexity : O(N) since we visit each node exactly once.
Space complexity : O(N) to keep the entire tree.