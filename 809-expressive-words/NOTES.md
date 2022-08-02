## Approach:
* For each word, check if it is expressive or not.
* For this if length of word is greater then length of extended string return false.
* Else iterate over both the strings, keep count of current chars. If current char in both strings are different then return false.
* Else if count of character in both strings if equal or count of character in s greater then or equalt to 3 also count in s greater then count in word continue checking for others. Else return false.
* If we reach end of only one string return false else return true.
​
### Time Complexity: O(N x Len)
### Space Complexity: O(1)