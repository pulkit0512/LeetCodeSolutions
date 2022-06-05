## Approach: Using Priority Queue and Map
In this approach, first created frequency map of the num array then created a min heap priority queue sorted on frequency. If size of pq is greater then popping out the peek element since it will have minimum of all elements frequency. At end k elements present in pq are the answer.
​
### Time Complexity: O(Nlogk) if k<N and O(N) in the particular case of N = k. That ensures time complexity to be better than O(NlogN).
### Space complexity : O(N+k) to store the hash map with not more N elements and a heap with k elements.