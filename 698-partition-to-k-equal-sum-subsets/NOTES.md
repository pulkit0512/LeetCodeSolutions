## Approach: Memoziation DP with Bitmasking
* We need to split the input array in K mutually exclusive subsets with each subset having same sum.
* We can split the array in required number of subsets only if totalSum is divisible by K else we can't.
* So the maxSum of a subset will be totalSum/k.
* Also as an optimization we will sort the input array in descending order since if sort in ascending order we will have more recursion branches. This is because when the change in subset-sum is small, more branches will be repeatedly created during the backtracking process.
* For memoization we have a map to store previously calculated same results.
* Since max array size can be 15 we can use bitmasking to represent which array elements have been and which are not yet taken in any subset. 0 will represent not taken and 1 represents current element is already part of some subset of required sum.
* In backtracking if we are able to create k-1 subsets of equal sum then last subset will automatically have required sum.
* If current subset sum is greater then required return false and backtrack.
* If current mask answer already calculated return from memo DP.
* If current subset sum is equal to required sum, Increase the satisfied subsets count and set curSum to 0 for next subset and again start from index 0 to fetch if we can create more mutually exclusive subsets of required sum. If possible store result in memo DB and return true.
* Else we will try to put element from idx to n in current sum if that index bit is not set in mask. Set the bit in mask. Add current element value to current sum and recursively call next index.
* If after recursive calls we get true return else reset the current bit in mask and try for other unset bits.
* If nothing works set false for current mask and return.
​
### Time Complexity: O(Kx2^N), there will be 2^N unique combinations of subset since for each element we have 2 choices whether to include in subset or not. And this is done K times to get K subsets.
### Space Complexity: O(2^N + N), 2^N unique combinations of mask stored in map and recursive stack takes atmost O(N) space.