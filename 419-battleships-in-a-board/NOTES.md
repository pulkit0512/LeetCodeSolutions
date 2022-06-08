## Approach: One Pass O(1) space without modifying board
In this approach, if encounter 'X' increment the ships but if a 'X' is present on top or left then this current 'X' is extension of previous battle ship which we already counted so remove this ship count from ans since it will more counts for a single ship.
​
### Time Complexity: O(NxM)
### Space Complexity: O(1)