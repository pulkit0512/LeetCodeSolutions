## Approach: Range Interval
* If we need to move backward, Decrement the start of interval and increment the end of interval + 1 to nullify it's effect for other indexes outside it's range.
* If we need to move forward Increment the start of interval and decrement the end of interval + 1 to nullify it's effect for other indexes outside it's range.
* Use prefix sum from left to right to get the overall movement for current index.
​
### Time Complexity: O(Len + N), Len = Length of string and N = Number of shifts.
### Space Complexity: O(Len)