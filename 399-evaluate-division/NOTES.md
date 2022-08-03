## Approach: DFS
* First we build the graph which is map of string vs map of string vs double.
* In this graph, for a dividend as a key, will have a map as a value which will have all the divisors it has in the equations vs the value they provide for dividend/divisor.
* Also in the graph we will have divisor as a key, which will have a map as value which contains all the dividends it has in the equations vs 1/value they provide, i.e. divisor/dividend.
* So for each equation we will have two edges in the graph.
* Once we are done building graph, we can use DFS to find the path between any two nodes.
* Apart from this if dividend or divisor of the query doesn't exist in graph return -1.
* If both dividend and divisor are equal return 1
* Else perform dfs with backtracking on graph to get the result.
​
### Time Complexity: O(N + MN), N for building graph and for M queries in worst case we need to traverse all the N edges. So O(N + MN) = O(MN)
​
### Space Complexity: O(N + M), N for graph, recursion stack, visited set and M for output array.