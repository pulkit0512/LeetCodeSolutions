## Approach:
* In this question, to check a robot is making cycle or not we need at most 4 iterations of instructions. If after any iteration step is 0 i.e. we reach the origin return true. Else again start the iteration. After exhausting all cycles if we didn't reach origin return false.
* **This can be acheived using single cycle as well. If after the iteration if steps is 0 or we are not facing to North then true else false. Because if we are facing north then we will always move away from origin after each cycle.**
​
### Complexity Analysis
* **Time complexity: O(N), where N is a number of instructions to parse.**
* **Space complexity: O(1)**