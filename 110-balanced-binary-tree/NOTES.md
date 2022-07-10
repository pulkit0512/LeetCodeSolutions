## Approach:
* Bottom Up approach, and each subtree will return it's height and if balanced or not.
* If any of the subtreee is not balanced return false for subsequent calls.
* else return height of subtree and true for balanced substree.
​
### Time Complexity: O(N)
### Space Complexity: O(N), recursion stack