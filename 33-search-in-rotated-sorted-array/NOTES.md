## Approach: Binary Search
* Find a pivot index, i.e. index of the largest element in the array. Binary search works just perfect here.
* pivot index splits array in two parts. Compare nums[0] and target to identify in which part one has to look for target.
* Perform a binary search in the chosen part of the array.
​
### Time Complexity: O(LogN)
### Space Complexity: O(1)