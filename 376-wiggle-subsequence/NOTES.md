## Approach1: Linear DP
* Any element in the array could correspond to only one of the three possible states:
* up position, it means nums[i] > nums[i-1]
* down position, it means nums[i] < nums[i-1]
* equals to position, nums[i] == nums[i-1]
*
* The updates are done as:
*
* If nums[i] > nums[i-1], that means it wiggles up. The element before it must be a down position. So up[i] = down[i-1] + 1, down[i] remains the same as down[i-1]. If nums[i] < nums[i-1], that means it wiggles down. The element before it must be a up position. So down[i] = up[i-1] + 1, up[i] remains the same as up[i-1]. If nums[i] == nums[i-1], that means it will not change anything becaue it didn't wiggle at all. So both down[i] and up[i] remain the same as down[i-1] and up[i-1].
*
* At the end, we can find the larger out of up[length-1] and down[length-1] to find the max. wiggle subsequence length, where length refers to the number of elements in the given array.
​
### Time Complexity: O(N)
### Space Complexity: O(N) or O(1) for space optimized DP, since only previous state is needed.
​
## Approach2: Quadratic DP, similar to LIS
### Time Complexity: O(N^2)
### Space Complexity: O(N)