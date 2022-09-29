## Approach: Map with DFS
* From given input list of process id and parent process id, create a process map with key as parent process id and value as list processes having same parent process.
* Once done, run dfs on the map to get the list of all processes that will be killed.
​
### Time Complexity: O(N), We need to traverse over the ppid array of size n once. The killProcessDfs function also takes atmost n time, since no node can be a child of two nodes.
### Space complexity : O(n). map of size n is used.