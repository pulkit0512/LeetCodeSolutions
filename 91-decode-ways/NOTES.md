## Approach: DP
If start of string is 0 return 0 no combination is possible. Set base case dp[0], dp[1] to 1.
If current val and previous val number is less then 26 and previous val is not 0 then number of decoded ways for i+1 will be dp[i] + dp[i-1] else previous val is 0 decoded ways for i+1 will be dp[i]. Current number and previous number both are 0 then return 0 not possible to make combinations having 00. Current number 0 and previous number not 0 the decoded ways for i+1 will be dp[i-1].
​
### Time Complexity: O(N)
### Space Complexity: O(N), DP array.
#### We can change space complexity to O(1) since for each index we only depend on prev to indexes. So we can use two pointers to calculate this.