## Approach: TreeMap, merging 2D intervals
* From the given input array, we will create a new 2d array of start and end points. Each entry in 2d array will have x coordinate, it's height and a boolean to indicate weather it is a start point or not.
* Once done we sort new array on x coordinates in ascending order.
* In case of ties, We need to handle 3 cases
* First, if start of two buildings are same then we need to first process bigger building. So in this case sort in descending order of height. If done in opposite way, there can be a chance that both start points come into skyline output, since they may change the max height in the map twice.
* Second, if end of two buildings are same then we need to first process smaller building. So in this case sort in ascending order of height. If done in opposite way, there can be a chance that both start points come into skyline output.
* Third, if same x coordinate has a start of building and end of another building then in this case start will be given preference.
* Use a variable to keep track of max height till now.
* Once sorting is done, iterate over the sorted points if a start point is encountered then insert the height of this point in tree map.
* Else remove the height of end point from tree map.
* For each point get the current max height from tree map, which will be the last key. If current max height and max height till now are not same, then there is change in height due to current point. Add current point x coordinate and current max height to the result and update max height till now.
​
### Time Complexity: O(N + NLogN), N for creating points array and NLogN for sorting the array. And For N point we insert/remove from treeMap in LogN so this will be NLogN.
### Space Complexity: O(N) for points array.