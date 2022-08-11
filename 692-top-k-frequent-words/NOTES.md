## Approach:
* Use freqMap to get frequency of each string.
* Then on the map entry build the priority queue with custom comparator.
* Push the map entry in pq. If size of pq is greater then k then poll out the minimum frequency word.
* In the end we will have k map entries in pq with increasing order of frequencies create the result list from this and reverse it to get output in desired format.
​
### Time Complexity: O(NLogK)
### Space Complexity: O(N)