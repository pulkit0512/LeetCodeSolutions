## Approach: DP
* Used boolean DP array to store upto which index of given string we can make using the given words.
* For any new word if the dp[i-wLen] is true and we have a substring from i-wLen to i equal to the given word this word will also contribute to make the given string up to index i. So set dp[i] to true.
* Return dp[len]
​
### Time Complexity: O(Len x N x wLen), Len = string length, N = number of words, wLen = word Length
### Space Complexity: O(Len)