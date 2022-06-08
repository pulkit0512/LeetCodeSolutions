## Approach:
1. First calculated number of zeros which will be duplicated with in the given length.
2. During the first pass, also found the index which will now become the last index.
3. Now moving from index found in step to 0, if arr[i]!=0 push this element to arr[i+zero].
4. Else if arr[i]=0, we push one extra zero if with array length and then push zero from original array to next place to be filled.
​
### Complexity Analysis
* **Time Complexity: O(N)**, where N is the number of elements in the array. We do two passes through the array, one to find the number of possible_dups and the other to copy the elements. In the worst case we might be iterating the entire array, when there are less or no zeros in the array.
* **Space Complexity: O(1)**. We do not use any extra space.