## Approach: DP
* If start of string is 0 return 0 no combination is possible.
* Set base case dp[0], dp[1] to 1.
* Iterate from index 1, check if single character decoding is possible or not. For this previous character should be non zero. If possible dp[i] += dp[i-1].
* Check if double character decoding is possible or not. For this we need to check if previous and current chars make a number less then 26 or not. If yes dp[i] += dp[i-2].
* return dp[n-1] as answer.
​
### Time Complexity: O(N)
### Space Complexity: O(N), DP array.
#### We can change space complexity to O(1) since for each index we only depend on prev to indexes. So we can use two pointers to calculate this.