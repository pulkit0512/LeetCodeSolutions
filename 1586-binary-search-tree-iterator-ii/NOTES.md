## Approach:
* Used to stack one for next values and other for previous values.
* for next values, Used the stack to store the left subtree of the current node including it.
* If next is called return the val of top most node. And if that node has right child, implement the first step to get left subtree of top most node's right node. Set right child of node to null, if same node comes again then we won't add it' s left subtree again in the stack.
* For has hext check if stack is empty or not.
* for prev values, when in next call a node is processed move it to the prev stack. The top of prev stack will have last node processed that is pointer is on this right now. So pop and move this node back to next stack and return the value of node now on top in prev stack.
* For has Prev check if stack size is greater then 1 or not.
​
### Time Complexity:
#### hasNext() : O(1)
#### next(): we insert H elements in stack for a root and for them time complexity in subsequent calls will be O(1). Each node is pushed and poped exactly once in next() when iterating over all N nodes. So for N calls it has 2N operations so on average time complexity is O(1)
​
### Space Complexity: O(H), in stack at any point will have H elements which is equal to height of tree.