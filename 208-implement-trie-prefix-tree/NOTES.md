## Approach:
Trie implementation with TrieNode, each node having 27 TrieNode children (26 lowercase chars and 1 '#' to represent end of a word). While adding a word at end of word initialize last node's 26th index children to indicate word ends here.
​
### Time Complexity: O(N), N = word length
### Space Complexity: O(1)