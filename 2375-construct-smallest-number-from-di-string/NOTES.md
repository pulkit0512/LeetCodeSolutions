## Approach:
* Used a variable to track the last value we have used.
* If we encounter "I" increment the last value used and put it at current index.
* Else if we encounter "D" move the index ahead untill we get an "I" and from this index we start filling the answer right to left direction.
* Once done we place the pointer to rightmost index filled till now and proceed.
* If in end last index not yet filled, fill it incremented prev value.
​
### Time Complexity: O(N), length of pattern
### Space Complexity: O(N)