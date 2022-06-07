## Approach: Greedy
In this question, I have used a pointer to reach the end of target String. Untill we reach end for each traversal of source we check the longest subsequese of source as substring of target and increment target pointer if chars in both strings are equal and if for a iteration on source, target pointer doesn't change it means current target char not in source return -1. Else if we reach end of target ans will be number of iterations of source String.
​
### Time Complexity: O(NxM)
### Space Complexity: O(1)