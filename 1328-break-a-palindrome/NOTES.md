## Approach: Greedy
* If the length of the string is 1, return an empty string since we cannot create a non-palindromic string in this case.
* Iterate over the string from left to the middle of the string: if the character is not a, change it to a and return the string.
* If we traversed over the whole left part of the string and still haven't got a non-palindromic string, it means the string has only a's. Hence, change the last character to b and return the obtained string.
​
### Time Complexity: O(N)
### Space Complexity: O(N)