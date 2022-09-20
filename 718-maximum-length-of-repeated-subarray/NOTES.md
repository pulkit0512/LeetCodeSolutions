## Approach: Longest Common Subarray
* For both arrays applied LCS like DP.
* Iterate over both arrays, if current element is same in both then fetch maximum matches till now from previous  upper diaganal row add 1 to it.
* Else we need to start the subarray building again so set current value in dp to 0.
* From final DP state answer will be the maximum value.
​
### Time Complexity: O(NxM)
### Space Complexity: O(Min(N, M))