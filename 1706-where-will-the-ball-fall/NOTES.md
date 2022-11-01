## Approach: Simulation
* For each ball, start with 0th row and corresponding ball column.
* While we are in the board, if grid[i][j] = 1 then check if adjacent cell in grid[i][j+1] is also 1 then we can slide to the next row and col+1. Else break out we can't move ahead.
* While we are in the board, if grid[i][j] = -1 then check if adjacent cell in grid[i][j-1] is also -1 then we can slide to the next row and col-1. Else break out we can't move ahead.
* If we reach to the last row then answer for current ball will be the current column value else -1.
* Return answer array.
​
### Time Complexity: O(MxN)
### Space Complexity: O(1) except the output array.