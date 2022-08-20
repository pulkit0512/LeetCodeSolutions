## Approach1: String Contains
* While string contains "01" replace all occurences with "10" and we will get new string after each second.
* Once string doesn't contains anymore "01" return the number of seconds.
​
### Time Complexity: O(N x N), N = length of string
### Space Complexity: O(S), S = number of seconds since after each second we create a new string.
​
## Approach2: Move all the 1s to the right.
* In this approach, we move all the 1s to the right. If current 1 is at correct position from the left then continue.
* If time needed to move current 1 to required position is less then time we have spent then simply in next second current 1 will reach it's correct position.
* Else Time needed for current 1 to reach it's required position will be equal to current index - correct index.
​
### Time Complexity: O(N)
### Space Complexity: O(1)