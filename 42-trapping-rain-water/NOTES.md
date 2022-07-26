## Approach:
* For each index upto i from left get the maximum height and from right get the maximum height.
* So water we can trap at any idex will be equal to min from left[i], right[i] - height[i].
​
### Time Complexity: O(N)
### Space Complexity: O(N)