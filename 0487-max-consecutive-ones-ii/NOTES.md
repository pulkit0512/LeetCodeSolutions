## Approach: Sliding Window
* Maintain three pointers st, i and prev which will keep track of left boundary of window, right boundary of window and index of prev zero.
* If we encounter second zero, update max with max(max, i-st)
* Set the st pointer as prev + 1, which will indicate new left boundary one step ahead of previous zero.
* Set the prev pointer to current index having 0.
* In the end check the last window size with max and update accordingly.
​
### Time Complexity: O(N)
### Space Complexity: O(1)