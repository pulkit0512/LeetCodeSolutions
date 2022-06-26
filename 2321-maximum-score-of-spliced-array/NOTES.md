## Approach: Kadane's Algorithm
* maxSum(B) = sum(B) + kadane(A - B)
* maxSum(A) = sum(A) + kadane(B - A)
* Maximum sum will be always existing sum + swap elements which gives addtional sum equal to difference of values.
* So we can apply kadane on difference array to get maximum sum of difference subarray.
​
### Time Complexity: O(N)
### Space Complexity: O(1)