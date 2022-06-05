## Approach:
Create frequency map of each string using int array of 26, convert each frequency map to string by delimiting with '#' check if this freq String exist in map or not. If yes add current string to previous group else create a new group with this String.
​
### Complexity Analysis
* **Time Complexity: O(NK)**, where N is the length of strs, and K is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
* **Space Complexity: O(N)**, For each string create 26 size int array and then String builder of capacity 52. 26N+52N = 78N. So Complexity = O(78N) = O(N)