## Approach: Two Priority Queue
* Used priority queues as minHeap and maxHeap.
* For a given num at add operation we will have all elements greater then num in min heap and all smaller elements in max heap.
* After every add operation, size difference of both queues will be atmost 1.
* So if size same for both priority queues median is mean of peeks of both queues.
* Else median is peek of queue having larger size.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)