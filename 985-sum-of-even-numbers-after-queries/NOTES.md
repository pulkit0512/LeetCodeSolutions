## Approach: Array Sum
* Calculate sum of even numbers in nums.
* Now for each query, check if previous num was even, if yes subtract this value from sum.
* Apply the operation on given index.
* If new value is even, add it to sum.
* mark ans[i] as resulting sum.
​
### Time Complexity: O(N + Q), N = number of elements in array, Q = Number of queries.
### Space Complexity: O(Q) for output.