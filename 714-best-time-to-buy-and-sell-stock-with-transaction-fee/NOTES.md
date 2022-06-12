## Approach:
* In this DP, buy at previous sell and sell at prev buy - transaction Fee
* buyCurr = Math.max(buyPrev, sellPrev-prices[i])
* sellCurr = Math.max(sellPrev, buyPrev+prices[i]-fee)
* buyPrev = buyCurr
* sellPrev = sellCurr
​
### Time Complexity: O(N)
### Space Complexity: O(1)