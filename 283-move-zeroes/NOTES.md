## Approach:
* Use a zeroPtr to swap non-zero elements with that pointer.
* Iterate over the array, and in case non-zero elements swap non-zero element with elment pointed by zeroPtr and increment zeroPtr.
​
### Time Complexity: O(N)
### Space Complexity: O(1)