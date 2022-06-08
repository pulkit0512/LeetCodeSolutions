## Approach:
Used two pointers one at 0 and other at N. If encounter "I" then use start pointer value in answer array else end pointer value. Update the pointers after each processing. For last array value it will be last remaining value pointed by both st and ed. We can use any pointer to store value.
​
### Time Complexity: O(N)
### Space Complexity: O(N) for output array else no space.