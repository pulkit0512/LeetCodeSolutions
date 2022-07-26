## Approach:
* Serialize data using preorder tree traversal. And create a string if node null append a dummy value in string.
* For deserialization, split serialize data to string array and follow preorder traversal on array to create the tree.
​
### Time Complexity: O(N)
### Space Complexity: O(N)