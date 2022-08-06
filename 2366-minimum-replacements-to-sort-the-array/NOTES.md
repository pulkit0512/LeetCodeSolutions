## Approach:
* We need to make array non-decreasing by spliting a number into 2 smaller parts in one operation. So we don't need to make any change in the last number since breaking it into smaller won't help in making array sorted.
* Start from right to left. We try to break a number in to smaller parts using current upper bound we have. We can't have any number more then the current upper bound. Which is inturn the minimum element we noticed till now.
* Based on upper bound we get the number of partitions current element will be needed so that each partition of that number is less then current bound.
* Number of operations will be equal to number of split - 1.
* Also if current bound is greater then the minimum of the new split then update the upper bound.
​
### Time Complexity: O(N)
### Space Complexity: O(1)