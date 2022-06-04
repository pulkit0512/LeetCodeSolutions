## Approach1: Using Validate BST
At Each preorder call checked if current value exist in limits or not. If not return null else create the node and call the left and right child with updated limits.
​
### Complexity Analysis
* **Time complexity : O(N) since we visit each node exactly once.**
* **Space complexity : O(N) to keep the entire tree.**
​
## Approach2: Using DeQue
In this approach, pushed the root to deque, consider the peek of deque to be the parent and new node to be the child. While peek value is less then child value pop out the node and update parent. Once done if parent val is less then child val add child to the right else to the left. Add child to the DeQue.
​
### Complexity Analysis
* **Time complexity : O(N) since we visit each node exactly once.**
* **Space complexity : O(N) to keep the entire tree.**