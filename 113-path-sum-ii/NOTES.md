## Approach: Backtracking
* Traverse from root to leaf and if path from root to current leaf is equal to target sum then add this list to the result.
* Backtrack the last node from the arraylist and reduce sum till now by this removed value.
​
### Time Complexity: O(N x N), N is number of nodes and if we get a valid path N operation we need to copy the list to result.
### Space Complexity: O(N), recursion stack