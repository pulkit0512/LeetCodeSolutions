## Approach: Using Prefix Sum
In this Approach, **In the constructor** I have calculated the prefix sum row wise in O(N) time. **In the update function** find the previous value of existing cell and the find the increment we need to do current value and then to subsequent columns in O(N) time. In **sumRegion call** find the sum from row1 to row2 from col2 to col1-1 in O(N) time.
​
### Complexity Analysis
* **Time Complexity: O(N) for all three functions.**
* **Space Complexity: O(1) no new extra space needed**