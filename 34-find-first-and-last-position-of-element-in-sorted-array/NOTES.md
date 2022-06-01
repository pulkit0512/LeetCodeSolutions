## Approach:
In this approach, I have used binary search to first find weather given target exist in array or not. If not return. Else set range to current returned index and then I am trying to find the left end in the left of returned value using binary search and similarly for right end find the end in the right of returned value using binary search.
Return range.
​
### Time Complexity: O(LogN)
### Space Complexity: O(1)