## Approach:
* Create a map of Integer vs Set, which contains for all x cordinates set of y cordinates they have.
* Then iterate over the points in double loop and get two points which don't have common row or column.
* If p1[0].contains(p2[1]) && p2[0].contains(p1[1]) then we can form a rectangle calculate minimum area.
​
### Time Complexity: O(N x N)
### Space Complexity: O(N)