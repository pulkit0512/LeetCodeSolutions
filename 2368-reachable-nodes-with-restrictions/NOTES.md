## Approach:
* Create undirected graph from the edges and store the restricted nodes in set.
* Then simply do DFS traversal from node 0. To check max nodes we visited. Also maintain visited array to avoid revisting same nodes.
​
### Time Complexity: O(N)
### Space Complexity: O(N)