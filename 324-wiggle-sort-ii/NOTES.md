## Approach: Using QuickSelect
* In this approach, I have used quick select to find the median of array using the approach to find Kth largest element in the array here k = n/2. Using quick select all the values to left of median will be smaller then median and all values greater then median are to the right.
* Once found used two pointers:
* left=1, starts from odd index from the left
* right = n-1 if even else n-2, starts from even index from the right.
* The goal is to put all the greater then median numbers on the odd indices from the left and put all the lest then median numbers on the even indices from the right. And then the ones equal to the median to the remaining slots.
* If current number is greater then median and (either it's index is even or it is greater or equal to left) swap current number with left pointer number i.e. pointing greater number on the odd index and increment left by 2.
* If current number is smaller then median and (either it's index is odd or it is less or equal to right) swap current number with right pointer number i.e. pointing smaller number on the even index from right and decrement by 2.
* Else increment index.
​
### Time Complexity: O(N) average, worst O(N^2)
### Space Complexity: O(1)