## Approach:
* For each node in original list, inserted a clone node to next of it.
* Once done adding clone nodes for each original node in list, start populating the random pointers.
* If original node has random pointer then original node next's random pointer will be original node's random pointer's next. Since original node next is it's clone node only and original node's random next will be clone of original node's random pointer.
* Once we set the random pointers as well. Split the linked list in to original list and clone list. Return head of clone list.
​
### Time Complexity: O(N)
### Space Complexity: O(1)