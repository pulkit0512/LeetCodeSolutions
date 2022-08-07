## Approach:
* To check if there is any valid partition, we can DP with Memoization.
* At each index, we can check the condition for pair, if it's true we make recursive call at idx+2 index to check for further partitions.
* If we don't get anything for a pair, we check both triplet condition. If any of the condition is true we make recursive call at idx+3 index to check for further partitions.
* Store result in memo dp to avoid processing same indexes again.
​
### Time Complexity: O(N)
### Space Complexity: O(N)