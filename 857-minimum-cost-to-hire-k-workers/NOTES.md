## Approach: MAX_HEAP and Sorting
* There will be atleast one worker which will get it's minimum wage. Also since we need to pay in proportion to the quality of other workers being paid.
* We can do this by computing ratio of wage is to quality, since we need minimum cost. Sort the workers in ascending order based on this ratio which proportional to the wage. Since all workers will be paid atleast there minimum wage. We can't pay less then the minimum wage to any worker.
* We can have a priority queue of quality as max heap since for a group of K, if current worker is the captain having maximum quality then all other k-1 workers will have less quality then current worker. So current worker will be paid the minimum wage and all other k-1 workers will be paid in proportion to the captains quality which will be greater or equal to there minimum wage. And all will be happy.
* Return the minimum cost of all such K groups.
* At a time in the pq will have k+1 workers.
​
### Time Complexity: O(NLogK + NLogN), since K<=N so overall complexity is O(NLogN)
### Space Complexity: O(K), K workers in PQ