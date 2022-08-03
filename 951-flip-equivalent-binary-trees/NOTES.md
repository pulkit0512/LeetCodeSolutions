## Approach:
* There are 3 cases:
* If root1 or root2 is null, then they are equivalent if and only if they are both null.
* Else, if root1 and root2 have different values, they aren't equivalent.
* Else, let's check whether the children of root1 are equivalent to the children of root2. There are two different ways to pair these children.
* root1.left, root2.left && root1.right, root2.right
* root1.left, root2.right && root1.right, root2.left
​
### Time Complexity: O(Min(N1, N2)), number of nodes in tree1 and tree2.
### Space Complexity: O(Min(H1, H2)), height of tree1, tree2