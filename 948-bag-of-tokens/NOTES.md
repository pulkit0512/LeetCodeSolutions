## Approach: Greedy
* Sort the tokens, l = 0 and r = length - 1
* If there is enough power to flip the token[l], then do it and get 1 point.
* if there is not enough power to flip token[l], then use 1 point to get the token[r] power.
* If can not do both, stop.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(LogN) for Arrays.sort