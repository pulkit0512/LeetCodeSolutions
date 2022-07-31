## Approach:
* Intution behind this is, if we sort the array and then try to divide the array into increasing length of subarrays. Each subarray will definitely have more sum then previous subarray since it has more number of elements and greater elements since sorted. So the problem comes to the point in how many subarrays we can divide this array such that each subarray has more length then the previous one.
* For this we can check for given n, try to find the number whose sum of first natural number upto that point is less then or equal to given N.
* This number will be the answer since we can divide are array of increasing lengths upto this number only. Example for 6 we can divide it into 3 subarrays of length 1, 2, 3.
​
### Time Complexity: O(sqrt(N))
### Space Complexity: O(1)