## Approach:
* Using gap strategy first sort all the diagonals in upper half triangle of the matrix.
* Then sort the lower half triangle of the matrix.
* To sort the diagonals we can use count sort since all values are in a range of [1,100].
* For each gap, iterate over diagonal and get count of all the elements in it.
* Then re-iterate over the diagonal and fill the diagonal using the count array.
​
### Time Complexity: O(N x M)
### Space Complexity: O(1), inplace replacement and count sort array is of fixed length 100.