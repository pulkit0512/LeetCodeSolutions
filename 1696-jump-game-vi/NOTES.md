## Approach:
* Variation of finding max of all subarrays of size K.
* Use deque to store maximum of k elements. Traversing back, for each index score will be current value + maximum score of ahead K indexes which will be stored in peekFirst of Deque. If current element is k behind peekFirst element poll it out and also untill all the elements from last in deque are less or equal to current value remove them from last and store current value index as maximum for all those subarrays so that deque monotonically decreasing.
​
### Time Complexity: O(N)
### Space Complexity: O(1)