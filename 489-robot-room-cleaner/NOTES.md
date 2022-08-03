## Approach:
* Consider the room to be a infinite long 2D matrix and robot starts at 0,0 with facing up.
* Also mantain a visited set to keep track of cleaned cells.
* Order of movement is important and I have mantained a clockwise flow.
* Clean the current cell, add cell to visited set.
* Get the 4 neighbours in clockwise way, if neighbour not visited yet and it is not a obstacle make a DFS call
* Once done with DFS call, go back to original direction.
​
### Time Complexity: O(N-M), N cells and M walls.
### Space Complexity: O(N-M)