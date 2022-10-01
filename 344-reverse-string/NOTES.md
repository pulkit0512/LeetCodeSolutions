## Approach:
Set pointer left at index 0, and pointer right at index n - 1, where n is a number of elements in the array.
​
While left < right:
​
Swap s[left] and s[right].
​
Move left pointer one step right, and right pointer one step left.
​
### Time Complexity: O(N), length of input
### Space Complexity: O(1)