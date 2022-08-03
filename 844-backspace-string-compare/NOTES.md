## Approach:
* Use two pointers to iterate over both the strings in parallel.
* Iterate from right to left. And also use a counter to keep track of number of unsatisfied '#'
* While we don't reach to left of both strings, if we have unsatisfied number of '#' then we move are pointers to the left this is done for both strings.
* Once done if we reach left end of both strings return true.
* If we reach end of any one of the string return false.
* If characters pointed by both pointers are same decrement both pointers else return false.
​
### Time Complexity: O(M+N)
### Space Complexity: O(1)