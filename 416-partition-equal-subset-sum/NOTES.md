## Approach: Subset Sum Problem/Knapsack
* Compute the total sum, if odd return false. Since we can divide array in two parts of equal sum only if total sum is even.
* We use DP to compute subset having sum equal to totalSum/2.
* dp[0] = true, since 0 sum is possible with no elements.
* Iterate over that array and then if for previous state dp[j-nums[i]] or dp[j] is possible then in current state dp[j] is also possible.
* If we found a subset with sum equal to half of total sum return true. Else false.
​
### Time Complexity: O(N x (sum/2))
### Space Complexity: O(sum/2)