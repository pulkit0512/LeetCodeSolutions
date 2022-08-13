## Approach: DP
* For current i, get the number by setting rightmost set bit of current number to 0.
* So number of set bits for current number will be number of set bits from DP of previous step number + 1.
​
### Time Complexity: O(N)
### Space Complexity: O(1)