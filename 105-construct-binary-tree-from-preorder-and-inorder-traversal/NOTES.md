## Approach:
* Created a mapping of inorder elements with it's index. This done to get the left and right of inorder mappings based on the preorder element.
* For each recursive call preorder top element will be the root of subtree. And top of preorder will be used to split the inorder array in left and right substree for current node.
* recursively use this left and right inorder portions to construct binary tree.
​
### Time Complexity: O(N), for building map and tree recursively.
### Space Complexity: O(N), for map.