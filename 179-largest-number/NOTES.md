## Approach:
* Convert integer array to String array and then using custom comparator we build the largest number.
* Sort the String array, in custom comparator for 2 string a, b. Get two strings a+b and b+a
* Compare these two concatenated strings and sort the array.
* If a+b gives greater result then b+a this means string a will come before string b in sorted array and vice-versa.
* If after sorting the largest string is "0" then result is "0". Else return the concatenation of sorted array.
​
### Time Complexity: O(L x NLogN), L max length of string and N is number of strings. Here max length of string can be 10 characters max integer limit. So Final Complexity is O(NLogN)
### Space Complexity: O(N), for new String List.