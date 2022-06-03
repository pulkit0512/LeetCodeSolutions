## Approach: Prefix Sum
In this approach, in constuctor calcuted the prefix sum of array in O(N) time and for each query return pre[right] - pre[left-1].
​
### Complexity Analysis
* **Time complexity: O(1) time per query, O(n) time pre-computation.** Since the cumulative sum is cached, each sumRange query can be calculated in O(1) time.
* **Space complexity: O(1). Used input array as prefix array.**