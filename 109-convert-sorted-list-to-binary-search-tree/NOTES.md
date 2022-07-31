## Approach1:
* For each part of list find the middle node using slow fast pointer technique. Disconnect the first half from second half.
* The middle element will become the root of subtree and make left and right calls for left and right child of the root.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(LogN)
​
## Approach2:
* Convert it into array to avoid calculating mid again and again, time complexity reduces to O(N) but space complexity also increases to O(N)