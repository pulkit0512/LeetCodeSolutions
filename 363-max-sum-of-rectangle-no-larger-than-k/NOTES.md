## Approach:
* Let's define a function that gets us the result of the maximum possible sum of a sub-array with sum <= k for a given 1D array.
1. Let's initialize a variable for running sum with 0. Let's call it sum.
2. Initialize a sorted set to store prefix sums and add 0 to it.
3. Iterate each number in the 1D array.
4. Add current number to the running sum.
5. Find the closest value of sum - k greater than or equal to sum - k in the sorted prefix sums using binary search. Let's call it X.
6. If such a number is found store the maximum value of sum - X until now in a global variable.
7. Add the current running sum in the container for prefix sums.
8. Repeat steps 4 to 7 for all numbers in the 1D array.
* Initialize an array with length equal to the number of columns in the matrix. This will store 1D representation of the matrix, let's call it rowSum.
* Run a loop from 0 to rows in the matrix. This represents the starting row of the matrix that we are aiming to find a result for.
* At the beginning of this loop fill rowSum with 0.
* Run a nested loop that would again run from 0 to number of rows in the matrix. This represents the ending row of the matrix that we are aiming to find the result for.
* Perform a column-wise sum of the ending row with the 1D representation rowSum. This will be the 1D representation of the matrix between i..j.
* Run the algorithm to find the maximum possible sum of sub-array with sum <= k for this row.
* We repeat the above 5 steps for all combinations of i and j where i≤j.
​
### Time Complexity: O(min(m,n)^2 max(m,n) logmax(m,n)), M = Number of rows, N = Number of cols
### Space Complexity: O(max(M,N))