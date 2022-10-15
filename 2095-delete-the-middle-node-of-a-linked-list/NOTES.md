## Approach: Slow Fast Pointer
* If there is only one node, return null.
* Otherwise, initialize two pointers slow and fast, with slow and fast pointing to head.
* Also keep track of previous node of slow pointer.
* While neither fast and fast.next is null:
* we move fast forward by 2 nodes.
* we move slow forward by 1 node.
* Now prev will be predecessor of middle node.
* Delete next node of previous and return head.
​
### Time Complexity: O(N)
### Space Complexity: O(1)