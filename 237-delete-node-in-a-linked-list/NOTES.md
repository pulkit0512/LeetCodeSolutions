## Approach:
Since provided node is not a tail node, we can copy next node data to current node and delete the next node.
​
Copy data of the next node to the current node.
​
Change the next pointer of the current node to the next pointer of the next node.
​
### Time Complexity: O(1)
### Space Complexity: O(1)