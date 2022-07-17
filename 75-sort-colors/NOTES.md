## Approach: Dutch Flag Sort
* Initialized right boundary for 0, the next 0 will be added at this pointer and boundary will be increased to right accordingly.
* Initialized left boundary for 2, the next 2 will be added at this pointer and boundary will be increased to left accordinly by decreasing 2s pointer.
* And all the one's will lie in between right boundary of 0 and left boundary of 1.
* While i <= 2s Pointer:
1. If nums[curr] = 0 : swap ith and 0 pointer elements and move both pointers to the right.
2. If nums[curr] = 2 : swap ith and 2 pointer elements. Move pointer 2 pointer to the left.
3. If nums[curr] = 1 : move pointer i to the right.
​
### Time Complexity: O(N)
### Space Complexity: O(1)