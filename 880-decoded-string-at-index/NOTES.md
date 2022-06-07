## Approach:
* First, find the length of the decoded string. After, we'll work backwards, keeping track of size: the length of the decoded string after parsing symbols S[0], S[1], ..., S[i].
* If we see a digit S[i], it means the size of the decoded string after parsing S[0], S[1], ..., S[i-1] will be size / Integer(S[i]). Otherwise, if it is character and K%Size is 0 then current char is the answer and size-1.
​
### Complexity Analysis
#### Time Complexity: O(N), where N is the length of S.
#### Space Complexity: O(1).