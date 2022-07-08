## Approach:
Use a map to store previous number and it's index. At each index we will check if target-nums[i] present in map then we found the pair. Else store nums[i] and i in map.
​
### Time Complexity: O(N)
### Space Complexity: O(N)