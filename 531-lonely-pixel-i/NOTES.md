## Approach:
* Iterate over the cells in the matrix picture, for each black cell at (x, y):
* Increment rowCount[x] and colCount[y] by 1.
* Iterate over the cells in the matrix and for each black cell at (x, y) check if the value of rowCount[x] and colCount[y] is 1. If both values are 1, increment the variable answer by 1.
* Return answer.
​
### Time Complexity: O(M x N), M rows and N columns
### Space Complexity: O(M + N)