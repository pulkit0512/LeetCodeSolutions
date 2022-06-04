## Approach: Using Post Order Traversal
In this approach, I have used a variable leaf level to find the height of leaf, if that height already exist in the answer add root val to the existing list else create new list and add root value and return the current level to the upper recursive parent calls.
​
### Complexity Analysis
* **Time Complexity: Assuming N is the total number of nodes in the binary tree, traversing the tree takes O(N) time. Hence overall time complexity of this approach is O(N).**
* **Space Complexity: O(N), the space used by solution array.**