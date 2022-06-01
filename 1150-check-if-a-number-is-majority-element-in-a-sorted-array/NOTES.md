## Approach:
* In this approach, first calculated first and last position of given target, I have used binary search to first find weather given target exist in array or not. If not return false. Else set range to current returned index and then I am trying to find the left end in the left of returned value using binary search and similarly for right end find the end in the right of returned value using binary search.
* if range greater then length/2 return true else false.
​
### Time Complexity: O(LogN)
### Space Complexity: O(1)