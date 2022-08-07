* **Approach:** This question is a variation of DP. In this For each coin at a particular price check the number of coins needed to reach this price which will be minimum value of DP[amount] or DP[amount-curCoin]+1.
* This operation is only done if DP[amount-curCoin]!=Integer.MAX_VALUE
* Return value of DP[amount]
​
* **Complexity Analysis**
* n: Length of coins array
* **Time complexity : O(n*Amount).**
* **Space complexity : O(Amount)**. We use extra space for the memoization table.