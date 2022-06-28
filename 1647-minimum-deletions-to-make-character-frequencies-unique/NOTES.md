## Approach:
* Store the frequency for each character in the given string s in a frequency array called frequency. We store the frequency for a character c at index c - 'a'. Thus, we will need 26 indices (from 0 to 25) to store the frequencies of the characters.
* Sort the frequencies (frequency).
* Iterate over the frequencies in descending order, for each frequency:
* If frequency[i] >= frequency[i+1], add the difference of these two in the variable deleteCount. Change frequency of the current character frequency[i] to freq[i+1]-1 or 0 if negative.
* Return deleteCount
​
### Time Complexity: O(N + KLogK) here K=26 so complexity is O(N)
### Space Complexity: O(K) here K=26, so complexity is O(1)