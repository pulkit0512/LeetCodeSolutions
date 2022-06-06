## Approach:
* In this approach, Iterated from 0 to (1<<n) - 1, where n is length of input array. Then created a set of all indexes where bit is 1 in current number binary representation.
* for [1,2,3], traverse from 0 to 7
* 0 == 000 == []
* 1 == 001 == [1]
* 2 == 010 == [2]
* 3 == 011 == [1,2]
* 4 == 100 == [3]
* 5 == 101 == [1,3]
* 6 == 110 == [2,3]
* 7 == 111 == [1,2,3]
​
### Time Complexity: O(2^N)
### Space Complexity: O(1) no extra space needed apart from output which uses space O(2^N)