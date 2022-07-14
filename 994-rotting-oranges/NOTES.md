## Approach:
* BFS Traversal on grid. First push all rotten oranges in queue with time 0 and also calculate number of fresh oranges we have at time 0.
* Now during BFS traversal if for current rotten orange any of the neighbour is fresh orange then it will rot in current time + 1. And number of fresh orange count reduces by 1.
* If after BFS traversal fresh oranges become 0 return max time we got during BFS traversal else return -1.
​
### Time Complexity: O(N x M)
### Space Complexity: O(N x M)