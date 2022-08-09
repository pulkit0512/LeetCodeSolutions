## Approach1: Graph with Memoization
* From the given array create a factorMap where each number will have set of all it's factors from the given array.
* Once Graph is created we can run dfs on each number from the array and will use memoization to re computations.
* For each number as a root we can have two childs from it's factor set.
* Calculate number of ways both child can create trees as root using dfs.
* Once done, for current value, number of trees will product of number of trees from both children.
​
### Time Complexity: O(N x N)
### Space Complexity: O(N)
​
## Appoach2: Tabulation DP
* The root of binary tree will always be the maximum value. So we can sort the given array for index i, all nodes possible in that tree will be in the left of index i, since index i will have the max value for a tree.
* For each number store it's index in a map.
* Using double loop Two factors for arr[i] will be arr[j] & arr[i]/arr[j], if arr[j] divides arr[i] and index map also contains next factor arr[i]/arr[j]. Then number of trees for arr[i] will be product of number of tree possible by arr[j] & arr[i]/arr[j].
* Fetch the index of arr[i]/arr[j] from index map. And dp[i] += dp[j]xdp[arr[i]/arr[j]].
* Answer will be sum of all trees possible using each element.
​
### Time Complexity: O(NxN)
### Space Complexity: O(N)