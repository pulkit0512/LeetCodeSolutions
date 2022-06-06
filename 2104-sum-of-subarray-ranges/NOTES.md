## Approach1: Using Deque to get min and max of all subarrays of size K.
In this Approach, for subarrays of size K used Deque to find min and max of all sub arrays of size k and added difference of max and min to the sum. This is the same approach to min/max of all subarrays of size k. 
### Algorithm:
* Create a deque to store k elements.
* Run a loop and insert first k elements in the deque. Before inserting the element, check if the element at the back of the queue is smaller than the current element, if it is so remove the element from the back of the deque, until all elements left in the deque are greater than the current element. Then insert the current element, at the back of the deque.
* Now, run a loop from k to end of the array.
* Print the front element of the deque.
* Remove the element from the front of the queue if they are out of the current window.
* Insert the next element in the deque. Before inserting the element, check if the element at the back of the queue is smaller than the current element, if it is so remove the element from the back of the deque, until all elements left in the deque are greater than the current element. Then insert the current element, at the back of the deque.
* Print the maximum element of the last window.

### Time Complexity: O(N^2) above operation is done N times and complexity of this operation in O(N)
### Space Complexity: O(N) each deque of size at most N.

## Approach2: Using Monotonic Stacks.
```
Let's say the array is [3,1,2,4].
Subarrays will be:

Subarrays           Max-Min

[3]                 3 - 3	= 0
[3,1]				3 - 1	= 2
[3,1,2]				3 - 1	= 2
[3,1,2,4]			4 - 1	= 3
  [1]				1 - 1	= 0
  [1,2]				2 - 1	= 1
  [1,2,4]			4 - 1	= 3
	[2]				2 - 2	= 0
	[2,4]			4 - 2	= 2
	  [4]			4 - 4	= 0
Answer would be = 0+2+2+3+0+1+3+0+2+0 = 13

Let us calculate the total number of occurrences of maximum and minimum elements from these subarrays.

Maximum side occurrences: -------------------- reference (1)
'3' occurred 3 times
'1' occurred 1 times
'2' occurred 2 times
'4' occurred 4 times

Minimum side occurrences: -------------------- reference (2)
'3' occurred 1 times
'1' occurred 6 times
'2' occurred 2 times
'4' occurred 1 times

If we subtract the sum of total minimum value from the sum of total maximum value. Then also we can get the result right?
i.e.

Maximum side sum            Minimum side sum
(3*3) + (1*1) + 2*2) + (4*4)= 30    (3*1)+ (1*6) + (2*2) + (4*1) = 17
so, 30 - 17 = 13.
```

* So created two stacks min and max stack. In max stack while element to be pushed is greater or equal to peek pop it out. Find the number of subarrays in which popped element will be maximum which is number of elements smaller to left multiplied by number of elements smaller to the right multiplied by popped element value. Add this value to sum. Once done with while loop push the new element index to max stack and return maxSum.
* Similarly for minStack we check while element to be added is less then equal to peek find number of elements greater then popped value in left and right and do similar calculation. Store current index to min Stack return minSum.
* Once done return maxSum-minSum.

### Time Complexity: O(N)
### Space Complexity: O(N)
