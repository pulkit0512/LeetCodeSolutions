## Approach: Greedy
* Initialize max variable to keep track of maximum time to burst a balloon in each group.
* Also initialize sum to keep track of total time to burst all balloons in a group.
* And ans will keep track of minCost needed.
* For each group, calculate the total sum and max time to burst all balloons and max burst time of a balloon.
* As soon as a group changes, add result in answer. which will be sum-max.
* Perform above step for all groups and return ans.
​
### Time Complexity: O(N)
### Space Complexity: O(1)