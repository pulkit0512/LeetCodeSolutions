## Approach: DP
Find LCS of both Strings. Answer is sum of length of both String - (2 x LcsLength).
​
### Time Complexity: O(MxN), M and N length of words.
### Space Complexity: O(min(M,N))