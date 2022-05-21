This question is done using DFS traversal. At each cell we can goto the 4 neighbours which are not yet visited. So to not visited cells we can make a recursive DFS call.
Number of islands is equal to the number of time DFS is called from the main function. Because in one call it makes one island.
​
​