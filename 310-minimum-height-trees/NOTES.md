* In this question, I have used a level array to keep the track of which level index i belongs to. Created a undirected adjecency map from the given edges.
* I will try to make given tree node with 0 edges and will mark it to current level.
* In the queue will add all nodes with one edge, these nodes will become leaf nodes or will come at the current level. Also to distinguish between each level will a "null" to queue and if we encounter null and queue is not empty will add null and will increment the current level since queue is not empty remaining elements in the queue will belong to the next level.
* Once done with the BFS level order traversal. All the nodes which have the max current level or are inserted as the last level will belong to the answer list.
​
* **Complexity Analysis**
​
* Let |V| be the number of nodes in the graph, then the number of edges would be |V| - 1 as specified in the problem.
​
* **Time Complexity: O(∣V∣)**
* First, it takes |V|-1 iterations for us to construct a graph, given the edges.
* With the constructed graph, we retrieve the initial leaf nodes, which takes |V| steps.
* During the BFS trimming process, we will trim out almost all the nodes (|V|) and edges (|V|-1) from the edges. Therefore, it would take us around |V| + |V| - 1 operations to reach the centroids.
* To sum up, the overall time complexity of the algorithm is O(∣V∣).
​
* **Space Complexity: O(∣V∣)**
* We construct the graph with adjacency list, which has |V| nodes and |V|-1 edges. Therefore, we would need |V| + |V|-1 space for the representation of the graph.
* In addition, we use a queue to keep track of the leaf nodes. In the worst case, the nodes form a star shape, with one centroid and the rest of the nodes as leaf nodes. In this case, we would need |V|-1 space for the queue.
* To sum up, the overall space complexity of the algorithm is also O(∣V∣).