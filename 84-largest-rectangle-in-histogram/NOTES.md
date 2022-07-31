## Approach1: Two Stacks
* For an index find next Smaller height in left and right. So width for that index will be right-left-1. And area will become height * width.
* return max area.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
​
## Approach2: Similar to above approach with 1 stack
* For an index we will find next smaller to left for an index height[i]<height[st.peek()]. For st.peek() index next smaller to right will be index i only since height[i]<height[st.peek()].
* This will be width for current height and find max area accordingly.
​
### Time Complexity: O(N)
### Space Complexity: O(N)
​