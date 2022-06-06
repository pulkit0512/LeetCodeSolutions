## Approach:
In this approach, used map to store the index of continuous sum found for the first time. Sum will store (sum till now + nums[i] modulo k) modulo k. If we have seen current sum previously fetch index from map and update the len. If len>=2 we found the answer. Else add this new sum to the map with index.
​
### Time Complexity: O(N)
### Space Complexity: O(N)