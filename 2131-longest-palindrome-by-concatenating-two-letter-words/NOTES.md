## Approach: HashMap
* Iterate over the words array and create frequency map of all the words.
* Once done, iterate over the entry set of map.
* If current key have both same alphabets then check the frequency of word and if even add the 2xfreqOfWord to the length. Since all these words will be added to palindrome string.
* If current key have both same alphabets and frequency is odd for the first time then also add 2xfreqOfWord to the length and mark a boolean true to indicate oddFreq word found.
* Else add 2x(freqOfWord-1) to the length.
* In case both alphabets are different then check if map has a reverse word for the current key, if yes get the freq of reverse word and add 4xMin(freq, revFreq) since both words will contribute 2 to length.
* Mark frequency of current key to 0, since we can't use it again.
* Return length.
​
### Time Complexity: O(N + min(N, 26x26)), since maximum words of length 2 can be formed will be 26x26.
​
### Space Complexity: min(N, 26x26), since maximum words of length 2 can be formed will be 26x26.