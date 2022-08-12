## Approach: Trie
* Create a trie of all the words and each trienode will contain array of trienodes of size 26 and boolean variable isWord to indicate this trienode has a complete word.
* Once trie is created for search we iterate over the word and if it is a dot we make all possible 26 calls to the next level to see if it forms a word in trie. Else if it is a char and matches at current level move to next level else return false from here.
​
### Time Complexity: For definded words O(M) and in worst case of undefined word with all dots of length M it is O(26^M)
​
### Space Complexity: O(M), for recursion stack for a search word of length M.