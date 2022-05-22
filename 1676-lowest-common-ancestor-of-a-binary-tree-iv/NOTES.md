* **Approach:**
* In this question, converted the array of treenodes to set. And called a recursive function LCA. At each point if root is null we will return null. If root is in the set we will return root. Make recursive calls to left and right of root. And if both call are not null then current node is lca for the two nodes in the set so return this node. Else return one of the node which is not null.
​
* **Time Complexity: O(N)**
* **Space Complexity: O(N)**