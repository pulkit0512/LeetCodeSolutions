## Approach: DP
* In this houses are arranged in a circle so if we choose house 1 we can't choose house N.
* So to tackle circular case. We can move left to right from house 1 to N-1 and calculate maximum we can have from this. Then we can move from right to left from house N to 2 calculate maximum we can have from this path.
* Answer will be max from both paths.
* To calculate max from path below are the steps.
1. In this current state depends on weather we can rob current house or not.
2. For each state I am maintaining the amount of money we can have including the robbery to current house and amount of money we can have excluding robbery of this house.
3. Because we can't rob to adjacent houses, so if we choose to rob current house then include money for current house will be sum of exclude money of previous house plus amount from current house.
4. If we choose to exclude current house then exclude for current house will be maximum of previous house include and exclude since we can exclude two or more adjacent houses.
5. Return max of exclude include for last house.
​
### Time Complexity: O(N)
### Space Complexity: O(1)