## Approach:
In this Approach, I have used a distance variable to keep track of distance from root node. If we found the target node find nodes in child path of target node at distance K. Else we try to find target node in left or right of root node using recursion if found find the nodes down from the root node at same distance which target Node have.
​
### Time Complexity: O(N), N = number of nodes in tree.
### Space Complexity: O(N)