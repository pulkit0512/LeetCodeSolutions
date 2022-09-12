## Approach: Greedy with Priority Queue
* Build a pair list from given inputs, and sort it in descending order of efficiency.
* This is done so that if we have a group of k-1 engineers and we add the kth engineer then this engineer will have the least efficiency in the entire group.
* To keep track of speeds of group of k engineers we can use a priority queue of size k which will have k best speeds for current efficiency.
* If currently we have k size of pq then remove the least speed engineer and add current speed to the pq. Add this speed to current sum and it's efficiency will be the least in entire group. Multiply this efficiency with speedSum this will be the performance of this group.
* Keep track of max performance for each k group.
​
### Time Complexity: O(N (LogN + LogK)), NLogN for sorting and NLogK for priority queue of speeds of size K.
### Space Complexity: O(N + K), N for list of pairs and K for priority queue.