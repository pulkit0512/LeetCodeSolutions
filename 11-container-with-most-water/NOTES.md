## Approach: Used two pointers
In this approach, used two pointers from both the ends and calculated how much water these ends can contain, which is equal to (ed-st) x Math.min(height[st],height[ed]). Update ans with this calculated value. Update pointers having less height.
​
### Time Complexity: O(N)
### Space Complexity: O(1)