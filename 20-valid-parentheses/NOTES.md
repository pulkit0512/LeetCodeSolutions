## Approach:
Using stack if we encounter open brackets push into stack. If encounter close bracket and peek is open bracket for the same, pop out the peek else return false. In end if stack empty return true else false.
​
### Time Complexity: O(N)
### Space Complexity: O(N)