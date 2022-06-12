## Approach: Two Pointer
The idea is to find largest subarray with unique elements. To have current state of subarray I am using a set. If element not present in set, add it's val to score and set. If present in set update maxScore if less then current subarray score. Now need to remove all elements from subarray upto current duplicate number. So untill left pointer of subarray not equal to current pointer remove nums[st] from set and score.
​
### Time Complexity: O(2N) = O(N)
### Space Complexity: O(N)