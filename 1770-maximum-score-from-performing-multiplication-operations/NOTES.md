## Approach: DP
* In this approach, we have three states multiplication operations, left of nums and right of nums. So this becomes a 3D dp. But we can calculated right of nums using other two state varaibles.
* right = nums.legnth-1 - (opr-left), there are len(nums) elements in nums. If we have accomplished op operations, and the left-pointer is ahead by left, means there are op - left operations from the right side. Thus, right should be behind n-1 by op-left. Thus, this formula.
* dp[op][left] stores the maximum possible score after we have done op total operations and used left numbers from the left/start side.
* From this state, we have two options
* Select Left: Number of operations will advance by one. And, so does the left pointer. Thus, we will multiply mulitpliers[op] and nums[left] (since we have selected from left), and add this product to (optimal) result of state dp[op+1][left+1].
* Select Right: Then also the number of operations will advance by one. Then, we will multiply mulitpliers[op] with nums[n-1-(op-left)] (since we have selected from right), and add this product to (optimal) result of state dp[op+1][left] (Now, left will not increment since number has not been chosen from left).
* Select maximum of results obtained by selecting from Left, and Right.
​
### Time Complexity: O(MxM)
### Space Complexity: O(M)