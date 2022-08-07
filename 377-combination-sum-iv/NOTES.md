## Approach: DP
* We need to return all the different permutations which will sum to given target.
* For this we can use 1D dp to store number of different permutations we can have for a particular amount.
* For each amount, traverse over the candidates, number of ways to reach that particular amount will be sum of ways to reach i-nums[j] amount.
* This is done because from i-nums[j] ways we can add nums[j] in each way to get dp[i] ways.
​
### Time Complexity: O(Target x N)
### Space Complexity: O(Target)