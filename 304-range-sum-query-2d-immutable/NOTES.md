## Approach: Using Prefix Sum
* In this approach, I have calculated prefix sum of matrix first row wise and then column wise, in constructor call with complexity O(NxM).
* In the sum region function given the end points of opposite corners ans will be equal to prefix sum at row2, col2 plus row1-1, col1-1 subtracted by row1-1, col2 and row2, col1-1.
* This is done to remove some outside the required boundaries but we need to add row1-1, col1-1 prefix sum becuase this is intersection point included in both substractions so need to add one time.
​
### Complexity analysis
* **Time complexity : O(1) time per query, O(mn) time pre-computation.** The pre-computation in the constructor takes O(mn) time. Each sumRegion query takes O(1) time.
* **Space complexity : O(mn).** The algorithm uses O(mn) space to store the cumulative region sum.