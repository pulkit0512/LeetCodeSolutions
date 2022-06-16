## Approach: DP
* plus will have subsequence whose last element has contributed after adding it.
* minus will have subsequence whose last element has contributed after subtracting it.
* In case of addition, At each step either choose to add current element to previous minus or keep previous plus if maximum.
* In case of subtraction, At each step either choose to subtract current element from previous plus or keep previous minus if maximum.
* return max of plus or minus
​
### Time Complexity: O(N)
### Space Complexity: O(1)