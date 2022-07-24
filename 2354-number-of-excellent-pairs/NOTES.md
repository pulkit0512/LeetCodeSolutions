## Approach:
* bits(a OR b) + bits(a AND b) = bits(a) + bits(b), using inclusion-exclusion principle
* For each unique number calculate number of set bits. And increment the cnt of this set bits in cnt array which is used to store number of occurences of same set bit count.
* Once done if i+j>=k then number of pairs will be cnt[i] x cnt[j].
​
### Time Complexity: O(N), Integer.bitCount(n) works in O(1)
### Space Complexity: O(N), to store unique num.