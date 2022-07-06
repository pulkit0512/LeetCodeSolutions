## Approach:
* Go from left to right and distribute candies to children according to given conditions if rating of current child is greater then previous child give number of candies to previous child + 1. Else 1.
* Similarly do this from right to left traversal.
* Once done number of candies to ith child will be max of left[i], right[i].
* Return sum of candies
​
### Time Complexity: O(N)
### Space Complexity: O(N)