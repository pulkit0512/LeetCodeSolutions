## Approach: Post Order Traversal
* From each node first calculate the maximum consecutive increasing length of left and right child.
* Then check if we can append current node to left or right path.
* Get the longest increasing path from current node and upade it accordingly with maxPath.
* return the longest increasing sequence we can get from current node, which includes current node in it.
​
### Time Complexity: O(N)
### Space Complexity: O(N)