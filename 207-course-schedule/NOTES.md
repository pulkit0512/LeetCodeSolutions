## Approach: Topological Sort
* Created a adjacency list of indegree and count outdegree array for course.
* Then used BFS traversal on outdegree array for all nodes whose outdegree is 0.
* In BFS traversal reduce the outdegree for all the courses which are dependent on current course i.e. indegree of current course. And while reducing the outdegree if it becomes 0 add the course in queue.
* After BFS traversal if outDegree of any course is not 0 then return false else true.
​
### Time Complexity: O(N+M), N = Number of courses, M = Number of dependencies.
### Space Complexity: O(2N+M) = O(N+M)