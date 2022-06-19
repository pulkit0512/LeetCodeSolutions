## Approach: Variation of LIS
* To calculate the binary value of subsequence, start from right.
* The logic here is that we first visit the previous string indexes to check that if they are making a binary string less than k. Now we will check if adding current element to that subsequence, will it make a value less than k, if yes, then we will add this current element to that subsequence, now we keep on doing this for every previous element and will store the max length.
​
### Time Complexity: O(Len x Len), Len is length of string
### Space Complexity: O(Len), DP Array