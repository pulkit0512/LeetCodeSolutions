## Approach: DP
### Intuition
Must cut across the entire height or width of the piece, this leads up to the dp soluition.
​
### Explanation
* The idea is to make horizontal cuts ie, if i make a cut of {i,j} I can further convert it into pieces of (ii, j) and (i-ii, j) and get the max ans
* Repeat above steps for vertical cut
​
* For a piece of w * h,
* we can make a vertical cut to split it into a * h and (w - a) * h
* So we can update dp[w][h] = max(dp[w][h], dp[a][h] + dp[w - a][h]).
​
* Or, we can make a horizontal cut to split it into w * a and w * (h - a)
* So we can update dp[w][h] = max(dp[w][h], dp[w][a] + dp[w][h - a]).
​
​
## Complexity
### Time O(mmn + mnn)
### Space O(mn)
​