## Approach: Deque
* BFS with null to identify whether a level is completed or not.
* Use a deque, for even levels, pollFirst() and addLast(). In case of null addFirst since this will be the ending of next level.
* for odd levels, pollLast() and addFirst(). In case of null addLase since this will be the ending of next level.
* Whenever a level is completed add the list to the answer and increment the level.
​
### Time Complexity: O(N)
### Space Complexity: O(N)