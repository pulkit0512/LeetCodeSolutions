## Approach : Using One Queue
In this approach, I have used one queue and while pushing a element to queue. Push the element get the size of queue for upto size-1, remove to top element and add it back to queue to so that new element always remains on the top. To pop() just remove the top element. For top() return value of top element. For empty check size of queue.
​
### Complexity Analysis:
#### Push: O(N), becuase for each push we revert the queue
#### Pop: O(1), removing and returning top element
#### Top: O(1), returning top element
#### Empty: O(1), checking size of queue.