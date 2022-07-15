## Approach1: TreeSet Higher() and Lower()
* Used TreeSet for each color with it's index values.
* Then for each query if index have same color add 0, else for given color from it's treeset get the higher and lower value of index which will give next and previous index of given color.
* Calculate minimum distance from both ends.
​
### Time Complexity: O(NLogN + QLogN), NLogN for TreeSets and QLogN for each query we take LogN time.
### Space Complexity: O(N)
​
## Approach2: By PreComputing distance
* Using three pointers one, two, three that will point to last occurence of color in the left.
* In this we move from left to right and for each index calculate the distance of all three colors to the left from that index. And update the pointer of current color with current index. If any color not yet visited distance to that color is Integer.MAX_VALUE.
* Then we move from right to left and for each index calculate the distance of three colors to the right from that index. And update the pointer of current color with current index. Update the distance for color at particular index only if it less then previous traversal value.
​
### Time Complexity: O(N+Q)
### Space Complexity: O(N)