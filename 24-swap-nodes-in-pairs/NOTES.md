## Approach:
* Reversing in group of k, here k = 2
* When a group is reversed, newHead is null then head of current group will be newHead and tail of current group will be newTail.
* if newHead not null, then newTail.next will be head of current group and newTail will be tail of current group.
* Next of tail of current group will always point to current pointer to avoid cycle.
​
### Time Complexity: O(N)
### Space Complexity: O(1)