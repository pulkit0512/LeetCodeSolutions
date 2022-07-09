## Approach: TreeMap
* Using treemap create a sorted map of absolute difference with number of occurences.
* Total atmax operations that can be performed on the treemap will be k1+k2.
* First try to make the top most pair of treemap equal to second pair if possible. Then pair 2 count will become pair2 count + pair1 count.
* Else try to equally distribute the operations among all the occurences of top pair.
* newKey will be topKey-equal operation distribution with count as previous count - occurences which can't be equally distributed.
* Occurences which can't be equally distributed will contribute to topKey-1 with remaining occurences as count.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)