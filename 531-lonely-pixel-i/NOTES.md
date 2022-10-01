## Approach: Linear Space
* Iterate over the cells in the matrix picture, for each black cell at (x, y):
* Increment rowCount[x] and colCount[y] by 1.
* Iterate over the cells in the matrix and for each black cell at (x, y) check if the value of rowCount[x] and colCount[y] is 1. If both values are 1, increment the variable answer by 1.
* Return answer.
​
### Time Complexity: O(M x N), M rows and N columns
### Space Complexity: O(M + N)
​
## Approach: Constant Space, Modifies original input
Find the lonely cells in the first row and column:
​
Iterate over the cells in the first row. For each cell (x, y), call the check() function to find the number of black cells in the first row and column. check() returns true if the cell (x, y) is the only black cell in the first row and column. If it returns a true increment the value at answer
​
Similarly, find the lonely cells in the first column by iterating over each cell in it and then calling the check() function.
​
Iterate over the first row and replace B cells with 1 and W cells with 0. Similarly in the first column replace B cells with 1 and W cells with 0. This row and column will be used as counters.
​
Iterate over the cells with row [1, M) and column [1, N) and for each black cell at (x, y) increment the count in the first row at picture[x][0] and picture[0][y] by 1.
​
Now iterate over each cell starting from the cell at (1, 1), and for each black cell, if the value at the corresponding row and column in the first row and column is 1, then increment answer.
​
Return answer.
​
### Time Complexity: O(M x N), M rows and N columns
### Space Complexity: O(1)