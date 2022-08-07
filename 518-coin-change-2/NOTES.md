## Approach:
* We need to find number of different combinations that will give the given amount.
* We can do this using 1D dp. DP[0] = 1 will be the base case, since we can make 0 amount in 1 way without using any coins.
* Then we iterate over each coin and try to find using this coin, in how many ways we can create particular amount which will be equal to dp[j] += dp[j-coins[i]]. That is add number of ways to existing count with how many number of ways we can create dp[j-coins[i]] in all those ways if we append current coin we will get the required amount.
​
### Time Complexity: O(N x Amount)
### Space Complexity: O(Amount)