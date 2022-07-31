## Approach:
* For both the nodes find all the nodes reachable from them and store the dist from that node to reachable node in map array. Also mantain the visited array to avoid going into cycles.
* Once dist map for both nodes are calculated. Find the node whose max distance from two input nodes is minimum then all other nodes.
* Return this node as answer.
​
### Time Complexity: O(V+E)
### Space Complexity: O(V)