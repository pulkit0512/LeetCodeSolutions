## Approach1 : Max Heap
* In this approach, I have used a max heap to add number of bricks used for each jump and whenever we can't consume the next climb we remove the most expensive climb from max heap and decrement a ladder indicating now most expensive jumb was taken using a ladder. And if we can consume this climb using current number of bricks we take that climb using bricks, add the climb to the priority queue.
* If no ladder or bricks needed just continue.
* Return the maximum index we can reach.
### Time Complexity: O(NLogN)
### Space Complexity: O(N)
​
## Approach2: Using Binary Search
* In this approach, I have created a list of pair of climbs and the index at which we need to take that climb. Sort the list.
* Then we can perform binary search on original height array to check if we can reach a specific building or not with given amount of bricks.
* The last true from binary search will be the answer.
* To check if we can reach a specific index, if the building in sorted list is in the range of binary search, then use bricks for shorter climbs until they can consume climbs and then start using ladder for next climbs.
* if we reach the end then return true else false
​
### Time Complexity: O(NLogN) for sorting and then O(NLogN) LogN for binary search and N for each check if reachable or not.
### Space Complexity: O(N)