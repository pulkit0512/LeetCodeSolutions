## Approach: PreOrder traversal
* Used a string builder to get the final string. If current node is not null append it's value.
* If left child not null append '(' to the string and make left call, once we return from this call close the left child.
* For right child if not null, if it's left child was null append () for the left child for one-to-one mapping and then do the same for right child as we did for left.
​
### Time Complexity: O(N), N = Number of nodes.
### Space Complexity: O(N), output string