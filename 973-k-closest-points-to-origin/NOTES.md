## Approach: Using priority queue as max heap
* In this question, I have used priority queue of integer array as max heap sorted on distance.
* First inserted the k pairs to priority queue. then from k to n-1 if distance is less then distance of peek point. Poll that point out and insert new point to queue.
* At end we will have K closest points from origin in the queue. Return them as array integer.
​
### Complexity Analysis
* Here N refers to the length of the given array points.
​
* **Time complexity: O(N⋅logk)**
* Adding to/removing from the heap (or priority queue) only takes O(logk) time when the size of the heap is capped at k elements.
​
* **Space complexity: O(k)**
* The heap (or priority queue) will contain at most k elements.