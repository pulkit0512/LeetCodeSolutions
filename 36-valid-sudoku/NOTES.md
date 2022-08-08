## Approach1:
* Validate board, using sudoku rules.
​
### Time Complexity: O(N x N x N), here N=9 so O(1)
### Space Complexity: O(1)
​
## Approach2:
* In this used 3 2D arrays for rows, cols and sqaures of 9x9
* If for current row particular index is already filled return false. Else fill that cell.
* Similarly if for current col particular index is already filler return false. Else fill that cell.
* Else for particular square at 3*(row/3) + col/3 is already filled return false else fill that cell.
​
### Time Complexity: O(N x N) here N=9 so O(1)
### Space Complexity: O(N x N) here N=9 so O(1)