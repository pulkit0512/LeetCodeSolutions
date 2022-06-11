## Approach: DP
* In this DP, used MxM dp array to store the maximum score with i operations and out of left number of operations are those which were performned multiplying with left extreme. We calculate right index from operation idx and left idx.
* DP[i][j]= Math.max(multi[i] * nums[left] + dp[i+1][left+1], multi[i] * nums[right] + dp[i+1][left])
* Return dp[0][0].
​
### The time and space complexity of both implementations is O(m^2) where m is the length of multipliers.