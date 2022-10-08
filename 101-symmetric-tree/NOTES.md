## Approach:
* From root node, we will check for two nodes every time for symmetry.
* Make a call to helper function using two root references.
* In recursive calls if both nodes are null return true.
* Else if either of the node is not null or value of both node are not same return false.
* Else make recursive calls on both nodes children.
* (left.left, right.right) && (left.right, right.left) check symmetry in both pairs.
​
### Time Complexity: O(N)
### Space Complexity: O(N) for recursion, bounded by height of tree in worst case O(N).