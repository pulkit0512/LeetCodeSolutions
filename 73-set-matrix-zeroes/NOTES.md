## Approach1: Using M+N space
In this approach, Used two arrays for marking affected rows and columns. If matrix[i][j] = 0 then row[i] = 1 and col[j] = 1. Then Iterate over the matrix again if row[i]==1 || col[j]==1 set matrix[i][j] to Zero.
​
### Time Complexity: O(NxM)
### Space Complexity: O(M+N)
​
## Approach2: Using Constant space.
In this approach, Used row[0] and col[0] as indicators, if matrix[i][j]= 0 then set matrix[i][0] = 0 and matrix[0][j] = 0. For matrix[0][0] used a seperate variable to mark for col 0 or row 0. If any element in column 0 is 0 then isCol flag is true.
Then traverse from 1,1 to n,m if matrix[i][0]==0 or matrix[0][j]==0 set matrix[i][j]=0.
If isCol is true set 0 Column set matrix[i][0] = 0 and if matrix[0][0] = 0 then set 0 Row matrix[0][j] = 0.
​
### Time Complexity: O(NxM)
### Space Complexity: O(1)