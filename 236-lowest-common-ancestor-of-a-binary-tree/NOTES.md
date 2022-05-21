* In this question of binary tree, We will use recursion to find the node who is lca of given nodes.
* If node is null then return null i.e in this path no node found.
* If node val is equal to any of the given node return that node, i.e. this node resides in the given path.
* Calculate left lca and right lca at each node.
* If both left lca and right lca are not null this means both given nodes lie on two sides of the current node. So current node is the answer.
* If either of the node is null this means the other node is the answer.
​
* **Complexity Analysis**
​
* **Time Complexity: O(N)**, where N is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.
​
* **Space Complexity: O(N)**. This is because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed binary tree could be N.