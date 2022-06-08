## Approach: Using 2 Deques
In this approach, used 2 deques to represent min and max of current subarray. For min queue while last>current val, remove last and then push the current val. For max queue while last<current val, remove last and then push the current val. If at any point maxPeek-minPeek is out of limit range. Poll the one with lower index and update the start pointer of subarray with polled value +1.
​
### Time Complexity & Space Complexity: O(N)