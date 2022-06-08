## Approach:
* In this approach, used similar approach to longest palindromic subsequence. Used to 2 2D array one to store length of longest palindromic subsequence and char 2D array is used to store the border character of the subsequence.
* Starting with even length sequence if both extreme are equal and last char of last[i+1][j-1] is not equal to current char then append extremes to that length increasing it's length by 2 and set last[i][j] to current char.
* Else dp[i][j] state will be same as state of max(dp[i+1][j], dp[i][j-1])
* Update max length if dp[i][j] is even.
​
### Time Complexity & Space Complexity: O(N^2)