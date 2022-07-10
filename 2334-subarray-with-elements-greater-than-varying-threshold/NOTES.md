## Approach: Stacks
* Using stack find the length of subarray where current element is minimum in the subarray.
* for current element i that is minimum for len[i] subarray, if (current minimum element > threshold/len[i]) then answer is len[i].
* If no subarray found return -1.
​
### Time Complexity: O(N)
### Space Complexity: O(N)