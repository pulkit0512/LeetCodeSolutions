* **Approach:** This question is a variation of DP. In this I have sorted the coins array to first process less value coin will take to reach a specific amout. And then for the next coins used the DP to check the minimum value of DP[amount] or DP[amount-curCoin]+1.
* This operation is only done if DP[amount-curCoin]!=Integer.MAX_VALUE
* Return value of DP[amount]
​
* **Complexity Analysis**
* n: Length of coins array
* **Time complexity : O(n*Amount).**
* **Space complexity : O(Amount)**. We use extra space for the memoization table.