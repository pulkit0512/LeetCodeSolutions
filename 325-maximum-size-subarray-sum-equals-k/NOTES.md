## Approach: Using Prefix Sum and map
In this approach, stored in map (0, -1) indicating we have 0 sum already at index -1. Now at each index calculated the prefix sum and if map contains prefixSum-k then updated ans if less then i-map.get(prefixSum-k). And stored the prefixSum and it's index in map if not already present.
​
### Complexity Analysis
* Given N as the length of nums,
* **Time complexity: O(N)**, We only make one pass through nums, each time doing a constant amount of work. All hash map operations are O(1).
* **Space complexity: O(N)**, Our hash map can potentially hold as many key-value pairs as there are numbers in nums. An example of this is when there are no negative numbers in the array.
​
​