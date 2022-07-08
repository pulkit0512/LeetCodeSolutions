## Approach:
Create frequency map of first string and then while traversing for second string if we get a char which doesn't exist in frequency map return false. Else decrease the occurence of char from frequency map.
​
### Time Complexity: O(N)
### Space Complexity: O(1), Since array of size 26 is used.