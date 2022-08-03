## Approach:
* Use two pointers to iterate over the list.
* Move first pointer N times ahead. Now if first pointer points to null, this means we need to remove the head of list. So return next of second pointer which is still pointing to next.
* Else while first pointer doesn't reach to end. Move both pointers ahead.
* Once 1st pointer reaches end, then we found the nth node from end which is next of 2nd pointer. So delete next of 2nd pointer.
​
### Time Complexity: O(N)
### Space Complexity: O(1)