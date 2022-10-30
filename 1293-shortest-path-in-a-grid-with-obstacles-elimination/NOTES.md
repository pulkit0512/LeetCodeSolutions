## Approach: BFS
* BFS on the grid using a queue of interger array containing 4 information: x and y coordinates, number of obstacles removed till now and number of steps till now.
* Also to keep track of which coordinates have been visited with specified eliminated obstacles, used a set of strings which will have xCoordinate_yCoordinate_obstaclesRemoved.
* If k>=m+n-2 then answer will be m+n-2 since maximum number of obstacles that can be removed is greated then number of cells in the grid.
* Now start the BFS with initial position of 0,0,0,0 which means (0,0) position with 0 obstacles removed and 0 steps taken.
* Perfrom BFS in all 4 directions, if next step is not an obstacle then check if it is already processed or not. If not then add new interger array to queue and also add the string to the set to mark visited.
* If next step is an obstacle then check if we have a capacity to remove one more obstacle if we can then add new integer array to queue and also add the relevant string to the set to mark visited.
* Once we reach (m-1, n-1) cell return the number of steps taken since BFS gaurantees shortest path.
* If we don't reach (m-1, n-1) during BFS operation return -1.
​
### Time Complexity: O(MxNxK), We conduct a BFS traversal in the grid. In the worst case, we will visit each cell in the grid. And for each cell, at most, it will be visited K times, with different quotas of obstacle elimination.
​
### Space Complexity: O(MxNxK), We used a queue to maintain the order of visited states. In the worst case, the queue will contain the majority of the possible states that we need to visit, which in total is MxNxK. Also set used to keep track of visited nodes will have atmost MxNxK space.