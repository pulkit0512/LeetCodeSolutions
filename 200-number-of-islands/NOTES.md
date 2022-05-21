* **DFS Approach:**
* This question is done using DFS traversal. At each cell we can goto the 4 neighbours which are not yet visited. So to not visited cells we can make a recursive DFS call.
* Number of islands is equal to the number of time DFS is called from the main function. Because in one call it makes one island.
​
* **Complexity Analysis**
​
* **Time complexity : O(M×N)** where M is the number of rows and N is the number of columns.
​
* **Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.**
​
* **BFS Approach**
* Using BFS traversal with queue, If we encounter a cell with value as 1. We add the cell row & col in queue with a value equal to row*colLength + col. After fetching the value from queue. Row = val/colLength & Col = val%colLength.
* If any of the neighbour is valid we add it's detail to queue.
* Each call to BFS will make one island.
​
* **Complexity Analysis**
​
* **Time complexity : O(M×N)** where M is the number of rows and N is the number of columns.
​
* **Space complexity : O(min(M,N))** because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).