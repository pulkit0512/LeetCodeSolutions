## Approach: Greedy
* In this greedy approach, fixed the partner at first position with an assumption that it is at correct place and we try bring the other partner to it's correct position if it's already not.
* Store the index of person[i]  as i in a map.
* For each partner at first place is row[i], then the next partner will be row[i]^1.
* If next partner i.e. at index i+1 is not equal to row[i]^1 then fetch the current position of row[i]^1 from map and swap element at i+1 with current position of row[i]^1.
* Also update the person mappings in the map with updated indexes.
* Increment the swap.
​
### Time Complexity: O(N)
### Space Complexity: O(N)