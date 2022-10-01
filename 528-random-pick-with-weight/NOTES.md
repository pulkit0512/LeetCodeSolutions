* **Approach:** In this question, We need to randomly pick an index and probability of picking an index is equal to w[i]/sum(w). So for this I have created prefix sum which will indicate the range for which ith index is applicable.
* For example for a array [1,9] prefix sum will be [1, 10] this indicates uptill 1 zero index has control and after 1 upto 10 index "1" has the contol.
* After the prefix sum generated for each pick index, I am using function and scaling it up to get random number between 0 and sum-1.
* We then need to find the index where random weight is greater than the prefix sum at a particular index. If found update start to mid+1, Which indicates for start answer is still ahead. Else update end to mid indicating answer is to left or equal to mid.
​
* **Complexity Analysis**
​
* Let N be the length of the input list.
​
* **Time Complexity**
​
* For the constructor function, the time complexity would be O(N), which is due to the construction of the prefix sums.
​
* For the pickIndex() function, this time its time complexity would be O(logN), since we did a binary search on the prefix sums.
​
* **Space Complexity**
​
* For the constructor function, the space complexity remains O(N), which is again due to the construction of the prefix sums.
​
* For the pickIndex() function, its space complexity would be O(1), since it uses constant memory. Note, here we consider the prefix sums that it operates on, as the input of the function.