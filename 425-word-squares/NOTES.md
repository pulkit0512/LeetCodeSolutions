## Approach:
* For each word in words, create a prefix map, where each prefix has list of all words which has the same prefix.
* Once done, we start with first word and insert into square and then we generate the prefix for next word using exisiting words in the square, by appending characters at the current index in each word.
* Once we get the prefix, from prefix map fetch all the words which has this as prefix. And then using recursion and bactracking we generate all the squares.
​
### Time Complexity: O(N x 26^L), N = number of words, L = length of word
### Space Complexity: O(N x L)