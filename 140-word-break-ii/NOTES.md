## Approach: DP
In this, First created a dp to store all the substring present in word dict ending at particular index. So dp[i] will have list of substrings ending at "i" and present in word dict.
Once the DP is ready if DP[len] is null return. Else we need to prepare the possible sentences start from the last index and using recursion build all the strings, For all the candidates at current index add it in sentenceSoFar and go to dp[i-currCandidate.length()] and recursively prepare possible sentence.
​
​