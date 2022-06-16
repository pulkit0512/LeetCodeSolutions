## Approach1: DP
In this approach, found the relation function of the series and dp[i] = 2*dp[i-1] + dp[i-3]
​
### Time Complexity: O(N)
### Space Complexity: O(1)
​
## Approach2: DP
* In this approach, we can create current board either from previous full board by adding vertical 2x1 tiles. Or we can create current board from previous to previous board by adding to horizontal 1x2 tiles. Or we can create current board from previous partial board having empty top right corners. Only top right corners because because we multiply it by 2 due to symmetry.
* And current partial board by adding tromino tile to previous to previous full board or by adding horizontal domino to previous partial board.
* dp[i] = dpFull[i-1] + dpFull[i-2] + 2* dpPartial[i-1]
* dpPartial[i] = dpPartial[i-1] + dpFull[i-2].
​
### Time Complexity: O(N)
### Space Complexity: O(1)