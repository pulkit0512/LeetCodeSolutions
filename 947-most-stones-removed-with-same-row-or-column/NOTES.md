## Approach:
* Create a adjacency undirected graph, for all indexes if for two points there row or column is same then there is an undirected edge between them.
* Once the graph is ready, do DFS on graph, number of points connected in one DFS call we can remove all of them except any one. So from each DFS call number of connected - 1 will stones will be removed.
​
### Time Complexity: O(N x N), to build graph and there can be at max N x N edges
### Space Complexity: O(N x N)