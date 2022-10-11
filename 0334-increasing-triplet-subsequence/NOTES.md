## Approach: LIS in NLogN
* In this question, we can LIS NLogN version.
* Since we need a increasing subsequence of length 3, so initialized a LIS array of length 3, with first element as nums[0].
* Now iterate over the nums array from 1, if current num is greater then last element in lis array then add this element in lis array and increment it's length.
* Else Check in which position current number will come in LIS array using binary search.
* Update the value at that index.
* When lenght LIS reaches 3 return true. Else return false.
​
### Time Complexity: O(N), Binary Search is max Log2 so overall O(N)
### Space Complexity: O(1), array of length 3 is used.