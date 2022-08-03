## Approach:
* Binary search on numbers range. The minimum largest sum can be max of array and the maximum largest sum can be sum of all elements of the array.
* So low is max(nums), high is sum(nums)
* Binary search on this range. If mid value of this range split the array into <= m parts then mid will be the potential and we keep searching in left.
* Else we search in right.
​
### Time Complexity: O(NLog(Sum(nums) - Max(nums))
### Space Complexity: O(1)