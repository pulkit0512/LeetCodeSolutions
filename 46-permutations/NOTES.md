## Approach: Backtracking
* If the first integer to consider has index n that means that the current permutation is done.
* Iterate over the integers from index first to index n - 1.
* Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).
* Proceed to create all permutations which starts from i-th integer : backtrack(first + 1).
* Now backtrack, i.e. swap(nums[first], nums[i]) back.
​
### Time Complexity: O(Summation P(N,K)), k=1 to N
### Space Complexity: O(N!) for output