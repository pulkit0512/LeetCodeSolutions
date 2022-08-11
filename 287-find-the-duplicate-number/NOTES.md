## Approach1: NegativeMarking
* Iterate over the array and at each index get the absolute value from array and negative mark the number at current index value if it is positive. And if negative return the current index absolute value.
* Since only one number is appearing twice so that particular number will try to mark an index negative twice. So this number will be the answer.
​
## Approach2: Cyclic Sort
* Input array will have values from 1 to N. And we will try to swap all elements at index 0 with the index of number at index 0. Since no number will be mapped to index 0.
* At every step swap nums[0] with nums[nums[0]] untill nums[0]!=nums[nums[0]].
* Return nums[0]
​
### Time Complexity: O(N)
### Space Complexity: O(1)