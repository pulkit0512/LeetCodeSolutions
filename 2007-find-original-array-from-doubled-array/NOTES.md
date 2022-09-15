## Approach: Count Sort
* Return empty array {} if the size of the given array changed is odd.
* Find the maximum element present in the array changed and store it in the variable maxNum.
* Declare the array freq with size 2 * maxNum + 1 and initialize the indices to 0. This is because we will iterate over numbers upto maxNum and hence we might check for 2 * maxNum in the freq array.
* Iterate over the numbers from 0 to maxNum, for each element num:
* Check if the count of num in the map freq is more than zero or not.
* Decrement the frequency of num in the count array.
* Check if the count of twiceNum (2 * num) in the count array.
* Decrement the count of 2 * num as well.
* If current num frequency becomes 0, add it to answer array.
* If it is not, then return an empty {} array.
* Return the array original.
​
### Time Complexity: O(N+K), N is number of elements and K is maximum number
### Space Complexity: O(K)