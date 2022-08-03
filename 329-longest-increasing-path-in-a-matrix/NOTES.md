## Approach: Memoization DP with DFS
* For each cell we can move to the 4 neighbours, but instead of calculating each path again for a cell which we already calculated. We can use memoization.
* If for any cell we have result calculated return the result from the cache.
* Check for all the 4 neighbours maximum length it can have.
* Store the maximum length for the cell in cache and return.
​
### Time Complexity: O(MN)
### Space Complexity: O(MN)