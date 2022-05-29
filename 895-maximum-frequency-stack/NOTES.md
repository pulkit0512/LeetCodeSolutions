## Approach: Using two Maps
In this question, I have used to Maps one to store the freq of each value we have got till now after applying push and pop functions. Other map is to store all the values having a particular frequency, it is a map of freq -> list of values. And I am also maintaining a variable to store max frequency till now. When we push a value and a freq level for that value freq doesn't exit creae new freq level in map add freq to the new level list and update the max freq. When pop is called remove the val which is present in the end of max freq list. And also reduce the freq of this number from freq map. If size of max freq list is 0 remove it and reduce maxFreq by 1. Return the val.
​
​
### Complexity Analysis
* **Time Complexity: O(1) for both push and pop operations.**
* **Space Complexity: O(N), where N is the number of elements in the FreqStack.**
​