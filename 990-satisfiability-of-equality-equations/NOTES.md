## Approach: Union Find
* Initialize the root and rank array for union find.
* Traverse the equations array, for all equalities create a union between left and right characters.
* Once done with equalities, again traverse the equation array, this time on inequalities. Check if left and right characters in the inequality are connected or not using find method.
* If connected this is not possible because a==b && a!=b can't be possible so return false.
* If every inequality passes return true in the end.
​
### Time Complexity: O(N), N = Number of equations.
### Space Complexity: O(1), since array of size 26 is used.