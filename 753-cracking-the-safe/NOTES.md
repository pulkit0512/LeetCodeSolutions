## Approach:
If there was no restriction on getting the minimum length which will guarantee to unlock the safe then answer would be concatenation of all k^n permuations of string.
But we need to return the minimum length which guarantee to crack the safe. So we still need all K^N permutations to be concatenated but in a greedy way.
What we can do to generate the next permuation is we can use the last n-1 characters and
append a new character. This will create a permutation and to make sure that this permutation already doesn't exist in the answer string. We keep a set of already existing permutations.
We stop the DFS once visited set size becomes equal to the k^n. At this point we have smallest string that has all k^n permutations in it. Else backtrack remove the permutation inserted in set and also remove the last character from answer string.
We start with all 0 string of length n.
​
### Time Complexity: O(K^N)
### Space Complexity: O(K^N)