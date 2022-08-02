## Approach1: Using Priority Queue
* Use priority queue in min heap, which will have object containing matrix value at row, col and that particular row and col.
* Since all rows are sorted insert first element of each row and there data in priority queue.
* Pop the peek of priority queue if for that row we have more elements insert the next element in Priority Queue. Once we got the kth element return.
​
### Time Complexity: O(min(K, N) + KLog(min(K,N))
### Space Complexity: O(min(K, N))
​
## Approach2: Using binary search
* For matrix, since all rows and columns are sorted but not the matrix as a whole we can't use direct binary search on the matrix.
* So instead of applying binary search on indexes, apply binary search on range of numbers.
* We can have min and max of the matrix from matrix[0][0] and matrix[n-1][n-1].
* Apply binary search on this range, get the middle number.
* Count the number of elements in matrix less or equal to middle element. Along with that keep track of largest element less or equal to middle element (Let it be L). Also we need smallest element larger then middle element (Let it be R).
* These additional two data which is left and right of middle is used to update the extremes of binary search.
* If count of elements less or equal to middle is equal to k then L is the answer.
* Else if count greater then k, We need to shift left so update max with L.
* Else we need to shift right so update min with R.
​
### Time Complexity: O(Log(max-min) x N)
### Space Complexity: O(1)