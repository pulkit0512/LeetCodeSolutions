## Approach: DP
1. In this current state depends on weather we can rob current house or not.
2. For each state I am maintaining the amount of money we can have including the robbery to current house and amount of money we can have excluding robbery of this house.
3. Because we can't rob to adjacent houses, so if we choose to rob current house then include money for current house will be sum of exclude money of previous house plus amount from current house.
4. If we choose to exclude current house then exclude for current house will be maximum of previous house include and exclude since we can exclude two or more adjacent houses.
5. Return max of exclude include for last house.
​
### Time Complexity: O(N)
### Space Complexity: O(1)