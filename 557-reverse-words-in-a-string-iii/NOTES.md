## Approach:
* Split string on spaces.
* For each word, reverse it and add it to final answer string.
* Append space after reversing each word.
​
### Time Complexity: O(N) Every character in the string is traversed twice. Thus the time complexity is, O(N+N)=O(N).
### Space Complexity: O(1), apart from output string.