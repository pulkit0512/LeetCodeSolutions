## Approach: 2d-DP
* Created a 2d dp, for first row and column if entry is 1 then dp[i][j] will be 1.
* For other cells, if value is 1 then to see size of square current cell can make we need to check it's three neighbours at (i-1, j-1), (i-1, j) & (i, j-1).
* Minimum value from these neighbours + 1 will be the square size for current cell.
* Return the area of maximum square formed.
​
### Time Complexity: O(M x N), M rows and N columns
### Space Complexity: O(M x N) and can be reduced to O(N) since we only depend on current state and previous state of dp.