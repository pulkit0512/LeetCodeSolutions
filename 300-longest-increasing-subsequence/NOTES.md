* **Approach1: N^2 Solution**
* Initialize an array dp with length nums.length and all elements equal to 1. dp[i] represents the length of the longest increasing subsequence that ends with the element at index i.
* Iterate from i = 1 to i = nums.length - 1. At each iteration, use a second for loop to iterate from j = 0 to j = i - 1 (all the elements before i). For each element before i, check if that element is smaller than nums[i]. If so, set dp[i] = max(dp[i], dp[j] + 1).
* Return the max value from dp.
​
* **Complexity Analysis**
​
* **Given N as the length of nums,**
* **Time complexity: O(N^2)**
​
* **Space complexity: O(N)**
​
* The only extra space we use relative to input size is the dp array, which is the same length as nums.
​
​
* **Approach2: NLogN solution**
​
* Initialize an array sub which contains the first element of nums.
* Iterate through the input, starting from the second element. For each element num:
* If num is greater than any element in sub, then add num to sub.
* Otherwise, perform a binary search in sub to find the smallest element that is greater than or equal to num. Replace that element with num.
* Return the length of sub.
​
* **Complexity Analysis**
​
* **Given N as the length of nums,**
​
* **Time complexity: O(N⋅log(N))**
* Binary search uses log(N) time as opposed to the O(N) time of a linear scan, which improves our time complexity from O(N^2) to O(N⋅log(N)).
​
* **Space complexity: O(N)**
* When the input is strictly increasing, the sub array will be the same size as the input.