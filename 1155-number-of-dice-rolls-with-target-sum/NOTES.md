## Approach: 2D DP
* In this states which are changing are the dices and sum on those dices.
* So we have a 2 states diceIndex and curSum.
* The base case is when we reach diceIndex at n and curSum at target then return 1.
* Iterate over the diceIndex from n-1 to 0 and then for each diceIndex iterate over curSum from 0 to target.
* For each combination, we need to find total ways to have this.
* Initialize a variable ways = 0, and Iterate over values from 1 to min(k, target-curSum) this indicates the values curSum can accept without exceeding the target.
* Total ways = ways + dp[diceIndex+1][curSum+i]
* current dp[diceIndex][curSum] = ways.
* Return dp[0][0].
​
### Time Complexity: O(N x T x K), N = number of dices
### Space Complexity: O(N x T)