## Approach: Morris Traversal
* Iterative approach to find inorder traversal
* Inorder is Left-Node-Right.
* If node left child is null then node will be current in the inorder traversal. Add it to list and move to right child.
* Else for the left child of current node find the right most child.
* If right most child's right is null then it's right will become current node and move to the left child.
* Else if right most child's right is current node then we have already processed the left subtree and reset the right child to null add current node value to list and move to the right child of current node.
​
### Time Complexity: O(N)
### Space Complexity: O(1)