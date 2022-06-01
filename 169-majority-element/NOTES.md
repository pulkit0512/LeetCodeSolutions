## Approach:
* In this approach first assumed nums[0] is the majority element and set it's count to 1 then from index 1 to n-1 if nums[i] is equal to majority element then increment the count else if count is 0 set the majority element to nums[i] and reset count to 1 else decrement the count of existing majority element.
* Return Majority element.
​
### Complexity Analysis
​
* **Time complexity : O(n)**, Boyer-Moore performs constant work exactly n times, so the algorithm runs in linear time.
​
* **Space complexity : O(1)**, Boyer-Moore allocates only constant additional memory.