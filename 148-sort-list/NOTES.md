## Approach: Merge Sort Linked List
* Recursive solution, base case if head or head.next is null return head.
* Find middle of list.
* First half head, will become head and second half head will become middle.next
* Set middle.next = null
* Recursively sort left and right of linked list. And at last merge the left and right part of list.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(LogN)