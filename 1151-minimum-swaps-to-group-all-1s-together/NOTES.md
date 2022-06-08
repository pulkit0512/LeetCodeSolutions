## Approach:
1. First caclucalate total number of 1 in the data.
2. We will use two pointers left and right to maintain a sliding window of length ones, and while we check every window through the input array data, we would calculate the number of 1's in it as inPlace and store the minimum swaps as length_ones-inPlace
3. While the window is sliding through data, we want to maintain its length as ones. At the same time, we also want to update the number of 1's in the window by adding the new boundary data[right] and deducting the left boundary data[left].
​
### Complexity Analysis
* **Time complexity: O(n)**, when n is the length of the array.
* **Space complexity: O(1).**