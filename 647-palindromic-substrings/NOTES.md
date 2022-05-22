Approach: In this question I have used 2D DP to keep track of all the palindromic substrings. Whenever we found a palindromic substring increment the answer by 1. All substrings of length 1 will be a palindromic substring. All substrings of length 2 will be palindromic if both characters are same. For more than 2 length subtring will be palindromic if extreme chars are equal and remaining part of that substring is already a palindromic substring.
​
Time Complexity: O(NxN)
Space Complexity: O(NxN)