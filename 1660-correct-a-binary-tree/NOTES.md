## Approach:
Used LinkedHashMap which can work as a queue and we can able to store node and it's parent's reference in map. Now using BFS level oreder traversal if for a node it's right child is already present in the map then this node is defective node and it's parent needs to remove this node. We can get the parent from LinkedHashMap. Once found just check the defective node is right or left child of parent node set that child to null.
​
### Time Complexity: O(N) for BFS traversal.
### Space Complexity: O(N) for linkedHashMap