## Approach:
In this approach, I have used total to store the total extra gas we have upto index "i" and cur to store extra gas stored from start index to current index. If current gas<0 then start points to the next index and current will become 0 since we start with an empty tank.
If after the entire iteration total extra gas is greater or equal to 0 then return start station else return -1.
​
### Time Complexity: O(N)
### Space Complexity: O(1)