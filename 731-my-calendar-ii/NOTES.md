## Approach: using boundary count method
* when a new event arrived increased the value of start by 1 and decrese value of end by 1 This will balance out the event.
* At any point while traversing over the sorted keys sum of values is >=3 then there is a triple booking for that instance
* revert the booking in map by decreasing value of start key and increasing value of end key. Return false else return true
​
### Time Complexity:
#### book : O(N)
​
### Space Complexity: O(N)