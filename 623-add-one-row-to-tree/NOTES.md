## Approach: BFS
* Using BFS we can keep track of level, we are currently at.
* If current level is required depth -1 then at level add a row using given rules.
* If required depth is 1, then create new root and add current root as left child of new root.
​
### Time Complexity: O(N)
### Space Complexity: O(N)