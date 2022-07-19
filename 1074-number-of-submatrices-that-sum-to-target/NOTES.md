## Approach: Extension of number of subarrays of sum equals K
* Compute prefix sum of the 2d matrix which is preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1]
* Once preSum is calculated, iterate over pair of rows such that we get all sub matrix between those rows varied by the column.
* Since two rows are fixed and only column is changing it becomes subarray 1D sum for that column between the two rows.
* Calculate the sum between the rows for that column and add the count of curSum-target from map to final ans.
* Also add increase the frequency of curSum in map.
​
### Time Complexity: O(R x R x C)
### Space Complexity: O(R x C)