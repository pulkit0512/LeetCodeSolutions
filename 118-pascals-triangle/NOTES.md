## Approach:
* Boundary of each row of pascal triangle is 1. And for rest of the elements, at index j it is sum of previous row value at index j-1 and j.
* Add current row to pascals triangle.
​
### Time Complexity: O(N x N), N = numRows
### Space Complexity: O(1), no extra space apart from output array.