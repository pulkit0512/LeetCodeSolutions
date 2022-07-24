## Approach: 3 State DFS
* Create a recursive function leadsToDest that takes the current node that needs to be processed and visited array.
* We check if this node has any neighbors or not. If it doesn't then we return true or false based on whether this node equals the destination node.
* There are three possibilities for the visited state of this current node.
* If it is 1, do nothing; we've already processed it.
* If it is 0, then mark it as 2 since we are starting the processing of the graph rooted at this node.
* Otherwise, if it is 2, then return false as we have discovered a backward edge, and hence a cycle.
* Traverse all the adjacent nodes and for each of them call the recursive function for that node. If the function returns false, return false.
* Mark the current Node as 1 and return true.
​
### Time Complexity: O(V+E)
### Space Complexity: O(V+E)