## Approach1: Memoization DP
* Used 3D DP on row, col, maxMove and for each cell called the 4 neighbours of cell and if it's value is out of boundary return 1 else if moves are exhausted return 0. If already have answer in memo DP return that.
​
### Time Complexity: O(M x N x MaxMove)
### Space Complexity: O(M x N x MaxMove)
​
## Approach2: Tabulation DP
* Used 2D DP on row, col and for current state to reach at cell i, j total paths will be previous state 4 neighbours sum of cell i, j.
* Count ways to get out of boundary only at boundary cells.
​
### Time Complexity: O(M x N x MaxMove)
### Space Complexity: O(M x N)