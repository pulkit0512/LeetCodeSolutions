## Approach:
* Create a map of sum of digits vs (max and max number of that sum). And if we get same sum again we will update max and 2nd max accoriding the current num. If we have both max and 2nd max for a sum of a digits. Update ans with sum of max, 2nd max if greater then previous value.
​
### Time Complexity: O(NLogN) for each num, sum of digits is calculated in logN.
### Space Complexity: O(N) for map.