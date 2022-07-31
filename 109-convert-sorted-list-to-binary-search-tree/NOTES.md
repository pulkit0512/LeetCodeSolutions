## Approach1:
* For each part of list find the middle node using slow fast pointer technique. Disconnect the first half from second half.
* The middle element will become the root of subtree and make left and right calls for left and right child of the root.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(LogN)
​
## Approach2:
* Convert it into array to avoid calculating mid again and again, time complexity reduces to O(N) but space complexity also increases to O(N)
​
## Approach3:
* Find the size of the sorted list.
* Use inorder property of BST, since it will give sorted list. So first element of inorder traversal will be left most element of the list.
* Similarly second last element of BST will second element of list.
* So we will first make the left calls to get part of subtree. Once done the head will still point to the middle node and it will become the root of subtree. Left of subtree will be left calcualted above and for right child, shift head to next and make recursive calls from mid+1 to ed.
* Return root.
​
### Time Complexity: O(N)
### Space Complexity: O(LogN)