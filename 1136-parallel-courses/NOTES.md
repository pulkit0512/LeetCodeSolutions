* Variation of topological sorting. Create a adjecency list of outdegree of each node and indeg array to store the number of prequisites we have for a given course.
* In the queue store the course and the semester in which we can take that course if inDeg of given course is 0.
* Maintain a list of courses we have taken till now.
* While poping from queue, add the course to the taken list, update the answer with the semester of polled course semester if it's more.
* And now from outdegree adjecency list reduce the indegree of all the courses whose prerequisite was the given. And if any course now don't have any prequisite add into queue with semester + 1 becuase this course can now be taken in next semester.
* Repeat the process untill or courses are taken or we reach a cycle.
​
* **Complexity Analysis**
* Let E be the length of relations. N is the number of courses, as explained in the problem description.
​
* **Time Complexity:** O(N+E). For building the graph, we spend O(N) to initialize the graph, and spend O(E) to add egdes since we iterate relations once. For BFS, we spend O(N+E) since we need to visit every node and edge once in BFS in the worst case.
​
* **Space Complexity:** O(N+E). For the graph, we spend O(N+E) since we have O(N) keys and O(E) values. For BFS, we spend O(N) since in the worst case, we need to add all nodes to the queue in the same time.