## Approach:
Using 2D DP with gap strategy. For gap 0 i.e. substring of length 1 it is true and length will be 1. Now using gap strategy if both extemes are equal then we can append these two chars in the diagonally left down sub sequence so dp[i][j] = dp[i+1][j-1]+2. Else Longest palindromic subsequence will max of dp[i+1][j] or dp[i][j-1]. Return dp[0][n-1].
​
### Time & Space Complexity: O(NxN).