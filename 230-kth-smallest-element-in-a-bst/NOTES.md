## Approach: Morris Traversal
* Morris inorder traversal, if left null go to right. Else find the righmost node of current node left child.
* If this leftRightMost right is null point it to current node for back traversal and move to left of current node.
* If leftRightMost right is already pointing to current node this means we have traversed every path for current node left tree. Print current node, remove right pointer of leftRightMost and move to right of current node.
* Find kth node using morris traversal.
​
### Time Complexity: O(3N) = O(N), since every node is visited atmost 3 times.
### Space Complexity: O(1)