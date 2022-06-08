## Approach:
Used Merge Interval technique on subStrings which needs to be bold. First found all the intervals of substrings need to be bold using indexOf. Then sorted the interval on start point and then applied merge interval technique to get merged bold tags which will be finally added in the input substring. Then traversed over stack created substring idx, pair[0] add bold tag then add the string which will be in bold pair[0] to pair[1] add end tag and and update the index to pair[1].
​
### Time Complexity: O(NxN)
### Space Complexity: O(N)