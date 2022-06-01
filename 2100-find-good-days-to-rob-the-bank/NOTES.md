## Approach:
In this question, I have used two arrays left and right to store length of non-increasing arrays from upto index "i" from left and right. Once done with this computation, iterate over the computed arrays and for a index if left[i] & right[i] are greater then equal to time add this index to ans list.
​
### Time Complexity: O(N)
### Space Complexity: O(N)