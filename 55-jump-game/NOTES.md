## Approach:
* Starting from index 0, maintain the max reach we can achieve. At each index update the reach with max of (reach, nums[i] + i) i.e. from index i upto which index we can jump. If at any index reach becomes greater or equal to n-1 then return true. Else false.
​
### Time Complexity: O(N)
### Space Complexity: O(1)