## Approach:
* Start with bottom left pointer and move untill we move out of grid.
* If matrix val at current pointers is greater then target then every value in current row will be greater then target so decrement the row pointer.
* If matrix val at current pointers is less then target then target can potentially be in the same row so increment the column pointer.
* If matrix val is equal to target return true.
​
### Time Complexity: O(M + N)
### Space Complexity: O(1)