## Approach: Stack
### Intuition
Iterating the input A backward, then for each A[i], find how many round it can eat on its right.
​
### Explanation
dpCount[i] means the number of element A[i] can eat on its right. More precisely, the number of rounds for an element A[i], to completely eat whatever it can eat on the right of A[i], if it is possible.
​
* Iterative input array A reversely,
* If A[i] is bigger the peek element A[j] of stack, this means A[i] can eat that element,
* Then update dpCount[i] to be max of dpCount[i] + 1 and dpCount[j].
​
### Example
* Take example of [10, 1, 2, 9, 1, 2, 3, 4]
* 10 can eat 1,2 in 2 rounds
* 9 can eat 1,2,3,4 in 4 rounds
*
* "max(dpCount[i] + 1, dpCount[st.peek()[1]]);"
* In this example
* dpCount[i] = 2,
* dpCount[i] + 1 = 3
* dpCount[st.peek()[1]] = 4
* finally we got the max rounds 4.
​
### Time & Space Complexity: O(N)