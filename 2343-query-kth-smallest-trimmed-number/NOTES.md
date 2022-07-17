## Approach: Map + Priority Queue
* Create a Map of Length of substring vs priorty queue of pair of string and it's index.
* Once done with map creation for each query get the priority queue of queried length from map. And get the kth value from it. And the reinsert the pairs back to priority queue.
* Return answer of array of indexes.
​
### Time Complexity: O(Len x N x (Len + LogN))
### Space Complexity: O(num of substrings)