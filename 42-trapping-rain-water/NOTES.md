## Approach1: Left right array traversal
* For each index upto i from left get the maximum height and from right get the maximum height.
* So water we can trap at any idex will be equal to min from left[i], right[i] - height[i].
​
### Time Complexity: O(N)
### Space Complexity: O(N)
​
## Approach2: Two pointers on extreme.
* If we notice in above approach, if right_max>left_max, then we only depend on left_max for the contribution. And vice-versa.
* So We can use two pointers left and right. And two variables to store left_max and right_max till now.
* If height[left]<height[right], then current height[left] is greater then left_max, update left_max else contribute left_max-height[left] to the ans.
* Similar to do in case height[right]>=height[left].
​
### Time Complexity: O(N)
### Space Complexity: O(1)