## Approach:
* PreOrder traversal, for each call get the middle element from the range it will become the root. And then call left and right array parts and prepare the rest of the tree.
​
### Time Complexity: O(N)
### Space Complexity: O(LogN), log N recursive stack since tree is heigth balanced.