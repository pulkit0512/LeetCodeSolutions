## Approach: Sweep Line Algorithm
* For each interval, check if remove interval intersects it or not.
* If no intersection, directly take the complete interval in output.
* In case of intersection, there can be three possibilities:
1. Remove interval completely lies inside current interval, in this case two intervals will be created one for the left non-overlapping part and other for the right non-overlapping part.
2. Remove interval overlaps the left part and in this case right remaining interval will be added in the output.
3. Remove interval overlaps the right part and in this case left remaining interval will be added in the output.
​
### Time Complexity: O(N), N = number of intervals
### Space Complexity: O(1), without considering output size.