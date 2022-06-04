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
### Space Complexity: O(LogN) recursion stack
​
## Approach2: Using Priority Queue as Max Heap
In this approach, insert all elements in PQ in reverse order as max heap then start populating odd indices from left to right first by polling out elements from queue. Then populate the even indices from left to right by polling out remaining elements.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(1)
​
## Approach3: Using Count Sort
In this approach, using count sort I have stored the frequency of all numbers in count array and then calculated the next greater element for each element if it's count greater then 0 and stored it in next array.
Now started rearranging nums array from right to left first with even indices and then with odd indices. This is done because we are moving from small to large in count and next array and even indices will have smaller values first and then the odd indices.
​
### Time Complexity: O(N)
### Space Complexity: O(1), since constant space of 5000 is used.