## Approach:
First calculate the number of square in first row and column. Then for others if matrix[i][j] not equal to 0 it will contribute to form one square. But we can have more squares based on the diagonally up, left and top cells no of squares contributed by cell[i][j] will be min of these three cells + 1.
​
### Time Complexity: O(MxN)
### Space Complexity: O(1)