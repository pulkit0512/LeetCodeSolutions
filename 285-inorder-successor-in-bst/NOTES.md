## Approach1: Using InOrder of Binary Tree
In this approach created a inOrder list, and made InOrder traversal call on root. At each inoder call checking if the last inserted node in list is required node or not. If it is return current node as answer else add current node to list.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
​
## Approach2: Using BST Properties
In this approach, used BST sorted property if required node value is greater or equal to current node then ans will be in right of current node. Else current node can be a potential answer and try finding next answer in the left of current node.
​
### Complexity Analysis
* **Time Complexity: O(N) since we might end up encountering a skewed tree and in that case, we will just be discarding one node at a time. For a balanced binary-search tree, however, the time complexity will be O(logN) which is what we usually find in practice.**
* **Space Complexity: O(1) since we don't use recursion or any other data structures for getting our successor.**