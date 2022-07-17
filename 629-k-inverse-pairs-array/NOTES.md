## Approach: DP
* if we know the solutions for count(n-1,0), count(n-1, 1)..., count(n-1,k), we can directly obtain the solution for count(n,k) as count(n,k)=sum of count(n-1, k-i), i from 0 to min(k,n-1)
* If n==0, no pair dp[0][j] = 0
* if k==0, one arrangement, dp[i][0] = 1
* Else dp[i][j] = sum of count (i-1, j-p) for p from 0 to min (j, i-1)
​
### Good Explaination: https://leetcode.com/problems/k-inverse-pairs-array/solution/
​
### Time Complexity: O(NK)
### Space Complexity: O(NK) can be reduced to O(K) since we only depend on prev state of DP