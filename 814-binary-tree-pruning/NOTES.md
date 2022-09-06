## Approach: Post Order
* For current node find if the left and right subtree has any 1 in it or not.
* If not set left/right child to null.
* If for a node it's value is 0 and both children are null then set this node to null.
​
### Time Complexity: O(N)
### Space Complexity: O(N)