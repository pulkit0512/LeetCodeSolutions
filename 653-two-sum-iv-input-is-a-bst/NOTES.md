## Approach1: Using Recursive Stack and Set
In this approach, used a set and recursive inorder traversal and at each inorder call checked weather target-curr.val exist in set or not. If yes return true else add curr.val to set.
​
### Complexity Analysis
* **Time complexity : O(n).** The entire tree is traversed only once in the worst case. Here, n refers to the number of nodes in the given tree.
* **Space complexity : O(n).** The size of the set can grow upto n in the worst case.
​
## Approach2: Using InOrder traversal
In this Approach, Using InOrder traversal created the list of values. Inorder traversal of BST gives a sorted list and then using two pointer approach tried finding the target.
​
### Complexity Analysis
​
* **Time complexity : O(n).** We need to traverse over the whole tree once to do the inorder traversal. Here, n refers to the number of nodes in the given tree.
* **Space complexity : O(n).** The sorted list will contain n elements.