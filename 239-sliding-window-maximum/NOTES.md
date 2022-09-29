## Approach: Sliding Window Max using Deque
* To keep track of sliding window, use a deque of size k.
* In deque new element will be inserted from right and maximum of that window will be the first element from left.
* For each element, remove all the smaller elements from deque from the right. So that deque will only have elements in descending order.
* If first element of deque is out of the window remove it.
* For each window the max will be the peekFirst element of deque.
​
### Time Complexity: O(N)
### Space Complexity: O(K), for deque. Apart from output array