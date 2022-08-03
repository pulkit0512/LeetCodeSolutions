## Approach: PostOrder
* Recursively via post order traversal, for a node get left and right sum.
* So the node value which will be returned to back to upper recursive call will be max(max (leftSum, rightSum) + node.val, node.val). This is becuase for a node either it's left sum or right sum will contribute to it's value or root.value will be maximum itself.
* So the node sum, having current node in the path, maximum sum can be max of left sum + right sum + node.val or nodeValue computed above.
* Compare the nodeSum with current max Sum and update accordingly.
* Return node value
​
### Time Complexity: O(N)
### Space Complexity: O(H), H is height of tree.