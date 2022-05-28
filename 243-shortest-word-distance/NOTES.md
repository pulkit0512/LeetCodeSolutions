## Approach
In this question, I have used two pointers to have a track of given words whenever I found a word and other word pointer is pointing to some index then update the ans with min of (ans, i - index of other word pointer). Return ans.
​
### Complexity Analysis
​
* **Time complexity: O(N⋅M)** where N is the number of words in the input list, and M is the total length of two input words.
​
* **Space complexity: O(1)**, since no additional space is allocated.