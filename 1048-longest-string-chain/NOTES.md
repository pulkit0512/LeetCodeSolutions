## Approach: DP
1. Sort the given words on length of words.
2. Intialize a dp with all values 1.
3. for current word of length "x" check all the words which have length "x-1" and found the largest chain for the word. This is similar to LIS problem.
4. Find the max from DP as answer.