## Approach:
* Store sum vs index in map.
* Treat 0 as -1 and make this as longest subarray with sum 0.
* If map already contains sum then the previous index of sum to current index of sum will be the length of subarray.
* Else put new sum with current index in map.
* return max length subarray.
​
### Time Complexity: O(N)
### Space Complexity: O(N)