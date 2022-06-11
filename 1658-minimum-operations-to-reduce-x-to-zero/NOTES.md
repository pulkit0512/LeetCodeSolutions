## Approach1: Using Map for cummulative sum from left
In this approach, I am storing cummulative sum from left in map with the length untill nums[i]<=x. If x present in map then length of x from left is potential answer. Once done start from the right end of array untill nums[i]<=x prepare cummulative sum and check if it's counterpart (x-sum) is present in map or not. If yes update ans with min of ans and length of left part from mam + right part length.
​
### Time Complexity & Space Complexity: O(N)
​
## Approach2: Using two pointers
1. Calculate the total sum of nums.
2. Initialize two pointers left and right to 0. Initialize an integer current to represent the sum from nums[0] to nums[left-1] and from nums[right+1] to nums[last].
3. Initialize an integer min to record the minimum length that sums up to x.
4. Iterate right form 0 to the end of nums. In each iteration:
*   Update current.
*   If current is smaller than x, move left.
*   If current is equal to x, update the maximum length.
5. Return the result.
​
### Time Complexity: O(N)
### Space Complexity: O(1)