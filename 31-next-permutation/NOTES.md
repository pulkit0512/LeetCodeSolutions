**Approach:** In this question, I have started iterating from right if we found a dip in the array then we have a scope to get the next permuation by swap this dip with value to right which is just greater then this value. If we don't found any dip reverse the array and return.
Else we get the dip using binary search find the just next greater value to right. Swap these two values. And then reverse the array after the dip. Resulting array will be next greater permutation.
​
**Complexity Analysis**
​
**Time complexity : O(n).** In worst case, only two scans of the whole array are needed.
​
**Space complexity : O(1).** No extra space is used. In place replacements are done.