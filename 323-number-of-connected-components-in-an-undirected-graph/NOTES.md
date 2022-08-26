## Approach1: Union-Find
* Initialize a variable count with the number of vertices in the input.
* Traverse all of the edges one by one, performing the union-find method combine on each edge. If the endpoints are already in the same set, then keep traversing. If they are not, then decrement count by 1.
* After traversing all of the edges, the variable count will contain the number of components in the graph.
​
### Time Complexity: O(E x @(N)), E = number of edges, and union method which is O(@(N)), where @(N) is the inverse Ackermann function.
### Space Complexity: O(V), V = number of vertices.
​
## Approach2: DFS
* Number of components will be number of DFS calls. In each call we will connect all the vertices which connected edges.
​
### Time Complexity: O(E+V), E = number of edges and V = number of vertices. O(E) to build adjacency graph and in DFS each node is visited once using visited array so O(V) time.
​
### Space Complexity: O(E+V), E for graph, V for DFS stack.