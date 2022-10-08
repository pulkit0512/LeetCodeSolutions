## Approach: boundary count method
* When a new event arrived increased the value of start by 1 and decrese value of end by 1 This will balance out the event.
* Return the maximum sum of values in the map.
​
## Let N be the number of events booked.
### Time Complexity: O(N^2). For each new event, we update the changes at two points in O(logN) because we keep the HashMap in sorted order. Then we traverse diff in O(N) time.
### Space Complexity: O(N), the size of diff.