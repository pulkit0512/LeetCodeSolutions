## Approach1: Greedy
* We try to add smalled boxes to the rightmost warehouse.
* Because lower heights for rooms on the left will block the entry of boxes into rooms on the right, we need to preprocess the array of warehouse heights such that it becomes a non-increasing sequence. Then, we start from the smallest box and the rightmost position of the warehouse. If the current box can fit in the warehouse room, we increment the count by 1 and move on to the next box. Otherwise, we move on to the next warehouse room and check if the box will fit there.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(1)
​
## Approach2: Greedy
* We try to add largest boxes from the leftmost warehouse.
* For this approach, we do not need to calculate the maximum height allowed for each warehouse room. This is because boxes are sorted in decreasing order, so a room with a low height will automatically omit all boxes that are taller than it.
* We start from the largest box and the leftmost position of the warehouse. When the box can fit in the warehouse room, we increment the count by 1. Otherwise, we discard the box and try a smaller one.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(1)