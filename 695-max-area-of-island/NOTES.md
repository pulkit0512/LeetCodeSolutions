## Approach:
BFS Traversal on grid on all 4 neighbours for an island. And return the max area.
​
### Time Complexity: O(R x C), R = rows and C = cols
### Space Complexity: O(min(R,C)), because in worst case where the grid is filled with lands, the size of queue can grow up to min(R,C).