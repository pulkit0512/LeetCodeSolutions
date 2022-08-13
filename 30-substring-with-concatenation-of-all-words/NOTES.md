## Approach: Sliding Window
* Since all words are of same length, so for each word to be substring we can take a jump of word length. And start from i = 0 to len-word.length() and for each iteration we will take a jump of word Length steps.
* From the given input string create a substring which will hold a substring from each index of length equal to word length.
* Also since words array can contain duplicate we convert this to a map containing word vs frequency of each word.
* Then we can use a sliding window for each starting index and sliding window will always take a jump of word length steps.
* Use a map and match counter to keep track of number of substrings matched to the given words.
* If frequency of a substring becomes greater then given frequency then using sliding window we try to reduce the frequency of current word by moving window to the right.
* If match count equals the number of words we found a substring which has all words concatenated store the starting index in the result. Move start pointer to the right with jump of word length and reduce match count by1.
* If at given index substring is not present in words then reset the match count, start index and freqMap.
​
### Time Complexity: O(a + Nxb), a = number of words. N = length of string and b = word length
### Space Complexity: O(a + Nxb) a = wordMap size, Nxb for substring map.