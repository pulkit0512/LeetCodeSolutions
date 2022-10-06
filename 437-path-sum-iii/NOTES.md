## Approach: Prefix Sum of a Subtree.
* Similar to number of subarrays whose sum equal equal to given value.
* Create a map which will keep track of frequency of a sum.
* Since in starting sum is 0, so insert an entry in map with 0 sum and count 1.
* Using DFS we will keep track of prefix sum till now.
* Get the count of sum whose value is sumTillNow-targetSum. Because for these count of subtree will from that point to current node will have sum  = targetSum.
* Increment the count of sum in the map.
* Make DFS call to left and right child.
* Decrement the count of sum in the map and remove current node value from the sum.
​
### Time Complexity: O(N)
### Space Complexity: O(N)