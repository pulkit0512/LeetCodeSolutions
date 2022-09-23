## Approach1:
* In this approach, for each number check the length by finding the position of most significant bit in logN, let say it's called msb.
* For current number, answer till now will move to left by msb positions and then current number will be added to it.
* Return final answer.
​
### Time Complexity: O(NLogN), N numbers and for each number we find the length in logN time.
### Space Complexity: O(1)
​
## Approach2:
* In this approach, we keep track of length of previous element. And the length of current element will be increased only if it is a power of 2.
* To check if a number is power of 2, we can check if (num&(num-1)) is 0 or not. If yes increase length of current number.
* Each time answer till now will move to left, buy the current number length's and then current number will be added to it.
* Return final answer.
​
### Time Complexity: O(N), since length is now calculated in O(1)
### Space Complexity: O(1)