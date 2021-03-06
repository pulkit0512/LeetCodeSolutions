* **Iterative Approach**
* Start with root node.
* Put the (root, root_state) on to the stack. root_state defines whether one of the children or both children of root are left for traversal.
* While the stack is not empty, peek into the top element of the stack represented as (parent_node, parent_state).
* Before traversing any of the child nodes of parent_node we check if the parent_node itself is one of p or q.
* First time we find either of p or q, set a boolean flag called one_node_found to True. Also start keeping track of the lowest common ancestors by keeping a note of the top index of the stack in the variable LCA_index. Since all the current elements of the stack are ancestors of the node we just found.
* The second time parent_node == p or parent_node == q it means we have found both the nodes and we can return the LCA node.
* Whenever we visit a child of a parent_node we push the (parent_node, updated_parent_state) onto the stack. We update the state of the parent since a child/branch has been visited/processed and accordingly the state changes.
* A node finally gets popped off from the stack when the state becomes BOTH_DONE implying both left and right subtrees have been pushed onto the stack and processed. If one_node_found is True then we need to check if the top node being popped could be one of the ancestors of the found node. In that case we need to reduce LCA_index by one. Since one of the ancestors was popped off.

**Recursive Approach**
In this I have used a global variable which will store the result LCA. At each recursive call if root is null then I am returning 0 indincating nothing found for this root. Else will make a call to left and right nodes. And will also check if the root value is equal to either of the given nodes. If any two out of the three checks is true then we update the LCA node with the root node. At end return true of false if we found 1 or more nodes in this call.

* **Complexity Analysis**

* **Time Complexity: O(N)**, where N is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.

* **Space Complexity: O(N)**. This is because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed binary tree could be N.
