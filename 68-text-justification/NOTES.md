## Approach: String Manipulation
In this I have used sumLen, start and cnt variable which stores sum length of words in the maxWidth range, start stores the index of word to be added in new line, we will add words from start index upto i-1 index and cnt have count of words. If sumLen till now plus length of current word and count of words(because there will be atleast one space between each word) is less then equal to maxWidth will take this word in current line. Else compute the current line using given conditions and then set sumLen to current word length, count to 1 and start points to i.
For last line it should be left justified, so compute it by adding words with a space and all remaining places left will be filled with space.
​
### Complexity Analysis
* **Time Complexity: O(N*L), where N = number of words and L = length of word**
* **Space Complexity: O(1) no extra space**