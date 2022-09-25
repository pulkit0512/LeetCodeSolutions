## Approach:
* Used an array of size K, to have k elements in queue.
* Also have st and ed pointers to keep track of start and end of queue.
* st indicates queue starts from this position and ed indicates upto this position queue is full and next element will come to ed+1 position.
* Also used a cnt to keep track of elements present in queue.
* In case of enqueue, check if queue is full or not. If full return false. Else increment ed pointer add value to queue. Increment counter and return true.
* In case of dequeue, check if queue is empty or not. If empty return true. Else reset st pointer value and increment st pointer to indicate now queue starts from this position. Also decrement the counter.
* In case of front, return value at st pointer.
* In case of Rear, if queue empty return -1 else return value of ed pointer.
* In case of isEmpty, check if cnt is equal to 0 or not.
* In case of isFull, check if cnt is equal to k or not.
​
### Time complexity: O(1). All of the methods in our circular data structure is of constant time complexity.
### Space Complexity: O(N). The overall space complexity of the data structure is linear, where N is the pre-assigned capacity of the queue.