## Approach:
* In this approach, traversed the matrix in clockwise direction. From left to right in topmost unvisited row, then up to down in rightmost unvisited column. Then check if we are not in same row if yes then right to left in downmost unvisited row. Then check if we are not in same column if yes then down to up-1 in leftmost unvisited column.
* Update the boundaries: up++, down--, left++, right--
​
### Complexity Analysis
* Let M be the number of rows and N be the number of columns.
* **Time complexity: O(M⋅N).** This is because we visit each element once.
* **Space complexity: O(1).** This is because we don't use other data structures.
​