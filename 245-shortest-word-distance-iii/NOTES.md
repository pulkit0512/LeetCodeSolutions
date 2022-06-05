## Approach
* In this question, I have used two pointers to have a track of given words whenever I found a word and other word pointer is pointing to some index then update the ans with min of (ans, i - index of other word pointer). Return ans.
* In case both words are equal I have used boolean equal to check weather both words in input are equal or not. If equal then if word1 is found again then returning minimum distance between two occurences of word1.
​
### Complexity Analysis
* **Time complexity: O(N⋅M)** where N is the number of words in the input list, and M is the total length of two input words.
* **Space complexity: O(1),** since no additional space is allocated.