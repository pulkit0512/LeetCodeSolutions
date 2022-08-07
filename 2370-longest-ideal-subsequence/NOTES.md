## Approach: DP
* Need to find the longest ideal sequence where adjacent characters should be atmost difference of K.
* We can do this using character DP, where each character stores maximum length of ideal sequence it can have, where this character is at end.
* Iterate over the string and for each char, check in character DP, max length for all the characters which can be adjacent to current char.
* So max length for current character will be maximum from all possible characters length + 1.
* Return answer as max length.
​
### Time Complexity: O(Len)
### Space Complexity: O(1)