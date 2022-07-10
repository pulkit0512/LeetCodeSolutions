## Approach1: Sorting with keeping track of index
* Create pair array with value and index. Sort on value.
* And check if we have two same values with index difference less then k.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
​
## Approach2: Using Set of max size k+1
* Use a set to check for duplicate. If found return true else add element in set.
* If set size greater then k remove (i-k)th element from set.
​
### Time Complexity: O(N)
### Space Complexity: O(N)