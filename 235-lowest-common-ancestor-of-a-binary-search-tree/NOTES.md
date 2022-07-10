## Approach1: Using BT
* Recursively find leftLCA and rightLCA if both are not null the LCA is root.
* Else if leftLCA is null rightLCA is ans else leftLCA.
​
### Time Complexity: O(N)
### Space Complexity: O(N), recursion stack
​
## Approach2: Using BST
* Iteratively if root.val is greater then both nodes ans is in left.
* if root.val is smaller then both nodes ans is in right.
* else root is the split and answer.
​
### Time Complexity: O(N)
### Space Complecity: O(1)