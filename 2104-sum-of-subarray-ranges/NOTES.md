'4' occurred 4 times
​
Minimum side occurrences: -------------------- reference (2)
'3' occurred 1 times
'1' occurred 6 times
'2' occurred 2 times
'4' occurred 1 times
​
If we subtract the sum of total minimum value from the sum of total maximum value. Then also we can get the result right?
i.e.
​
Maximum side sum            Minimum side sum
(3*3) + (1*1) + 2*2) + (4*4)= 30    (3*1)+ (1*6) + (2*2) + (4*1) = 17
so, 30 - 17 = 13.
```
​
* So created two stacks min and max stack. In max stack while element to be pushed is greater or equal to peek pop it out. Find the number of subarrays in which popped element will be maximum which is number of elements smaller to left multiplied by number of elements smaller to the right multiplied by popped element value. Add this value to sum. Once done with while loop push the new element index to max stack and return maxSum.
* Similarly for minStack we check while element to be added is less then equal to peek find number of elements greater then popped value in left and right and do similar calculation. Store current index to min Stack return minSum.
* Once done return maxSum-minSum.
​
### Time Complexity: O(N)
### Space Complexity: O(N)