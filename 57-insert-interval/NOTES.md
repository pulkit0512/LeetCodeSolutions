## Approach: Merge Intervals
* Used stack to merge intervals. Add/merge intervals untill intervals[i] start is less then newInterval start.
* Once we exceed the newInterval start add/merge interval with last added interval.
* And after that keep adding/merging remaining intervals.
* Return merge intervals from stack in reverse order.
​
### Time Complexity: O(N)
### Space Complexity: O(N)