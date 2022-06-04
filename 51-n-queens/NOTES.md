## Approach: Backtracking
* In this approach, for each row we check if we can place a queen at particular column and if yes we place the queen at row and col, make recursive call to next row and once we are back from the recursive call backtrack i.e. remove the queen placed before.
* Once we reach at the board length we have one solution.
​
### Complexity Analysis
​
* Given N as the number of queens (which is the same as the width and height of the board),
* **Time complexity: O(N!)**
* Unlike the brute force approach, we will only place queens on squares that aren't under attack. For the first queen, we have N options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N−4. This pattern continues, resulting in an approximate time complexity of N!.
* While it costs O(N^2) to build each valid solution, the amount of valid solutions S(N) does not grow nearly as fast as N!, so O(N! + S(N) * N^2) =O(N!)
​
* **Space complexity: O(N^2)**
* Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens. However, to keep the board state costs O(N^2), since the board is of size N * N. Space used for the output does not count towards space complexity.