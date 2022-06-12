## Approach:
In this DP, at each point either do nothing, or if we are holding a stock we can sell it or if we are not holding a stock we can buy it.
So dp[i][j] = Math.max(doNothing, doSomething)
doNothing = dp[i+1][trans][hold]
if hold==0 then buying = -prices[i] + dp[i+1][trans][1]
if hold==1 then selling = prices[i] + dp[i+1][trans-1][0]
Return dp[0][k][0] which is 0th day having k transactions left and not holding the stock which was our starting condition and build the dp in bottom up approach.
​
### Time Complexity & Space Complexity: O(N x K x 2) = O(N x K)
​
## Approach2: Simulation approach similar to buy and sell stock atmost 2 times.
### Time Complexity: O(N x K)
### Space Complexity: O(K)