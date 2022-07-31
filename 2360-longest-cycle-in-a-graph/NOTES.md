## Approach:
* Since each node can be part of one cycle, keep track of visited array with the node for which that cycle/dfs call started.
* For each unvisited node having distance 0, make a DFS call and if for a node it's distance is already calculated and this node was visited in current DFS call only then cycle exist. Update the answer with max of ans, (current val of dist - dist[node]).
* Store the node dist in distance array.
​
### Time Complexity: O(V+E)
### Space Complexity: O(V)