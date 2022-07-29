## Approach:
* Create mappings for pattern vs word and word vs pattern.
* If for any mapping same character is mapped to two characters then it is not a match.
​
### Time Complexity: O(N x K), N = number of words, K = length of word.
### Space Complexity: O(1), except output array.