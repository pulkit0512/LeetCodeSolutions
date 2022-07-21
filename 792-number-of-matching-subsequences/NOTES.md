## Approach:
* From the given string created a list of array of size 26 to store the indexes of each char in this list.
* Then iterated over each word and for current char tried Binary seach in it's index list.
* To do binary search maintained a index pointer which will tell us upto which index of given string we have and next char should be looked ahead of this index.
* Find the upper bound of index from index list of current char. If not found then current word is not a subsequence.
* Return number of subsequences.
​
### Time Complexity: O(S.length + (sum of words length) x (Log(S.length))
### Space Complexity: O(S.length)