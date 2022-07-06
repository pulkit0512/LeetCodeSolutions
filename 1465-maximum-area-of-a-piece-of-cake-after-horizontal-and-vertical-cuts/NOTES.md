## Algorithm
* Sort both horizontalCuts and verticalCuts in ascending order.
* Initialize a variable maxHeight as the larger of the top and bottom edge: maxHeight = max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]).
* Iterate through horizontalCuts starting from index 1 (skip the 0th index since it represents the edge cut, which we accounted for in the previous step). At each iteration, find the height defined by the ith cut and the nearest cut above, horizontalCuts[i] - horizontalCuts[i - 1]. Update maxHeight if necessary.
* Initialize a variable maxWidth as the larger of the left and right edge: maxWidth = max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]).
* Iterate through verticalCuts starting from index 1. At each iteration, find the width defined by the ith cut and the nearest cut to the left, verticalCuts[i] - verticalCuts[i - 1]. Update maxWidth if necessary.
* Our maximum area is maxHeight * maxWidth. Return the maximum area.
​
### Time Complexity: O(N.Log(N) + M.Log(M)), N and M are length of given arrays.
### Space Complexity: O(1)