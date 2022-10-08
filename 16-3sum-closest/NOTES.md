## Approach:
* Sort the input array in ascending order.
* Use three pointers, one for the outer loop and other two as two extreme points in the subarray ahead of the first pointer.
* Get the sum and check with the targetSum. If diff is more then curr difference update it and update answer as well with current Sum.
* If sum greater then target decrement the right pointer to lower values.
* Else if sum less then target increment the left pointer to higher values.
* Else sum and target are same return sum.
* Return the closest sum.
​
### Time Complexity: O(NxN + NLogN) = O(NxN)
### Space Complexity: O(LogN), sort takes LogN space.