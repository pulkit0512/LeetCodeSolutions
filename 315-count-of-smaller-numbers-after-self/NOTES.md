## Approach: Merge Sort
* Count inversion using merge sort can be used to calculate number of smaller elements after self.
* Using merge sort we sort the pairs containing value and it's index in decreasing order.
* During merge sort for ith index in first half is greater then jth index in next half then number of elements smaller then ith index to the right will right-j+1 since jth index is smaller and we sort in descending order so all elements after jth index will also be smaller then ith index.
* Complete the merge step. At end of complete merge sort we will get the result.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(N)