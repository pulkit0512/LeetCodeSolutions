## Approach:
* For each word in words2, create a frequency array and the overall frequency of a character will be equal to max of character frequency in single word.
* Then if a word in words1, for each character if frequency is greater or equal to overall frequency then this word is a subset.
​
### Time Complexity: O(A + B), where A and B is the total amount of information in words1 and words2 respectively.
### Space Complexity: O(1), apart from output.