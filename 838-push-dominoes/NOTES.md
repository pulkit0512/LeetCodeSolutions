## Approach: Adjacent Symbols
* Consider the left boundary has an Symbol 'L' at index '-1'. And the right boundary has an Symbol 'R' at index 'len'.
* Now we will have a char output array initialized with all chars as '.'
* Now moving left to right, get the adjacent L and R pairs. There can be 4 cases.
* For two cases If we have LL or RR pair then fill all the indexes between them with the same character.
* If we LR case, in this case we don't need to do anything. Since L will move to left side and R will move to right side. So NO COLLISION.
* If we have RL case then there will be a COLLISION at one index. So the first half indexes will be filled with R. The next half will be filled with L. In case the indexes between then are odd then one index will not move. Since force from both sides will balance.
​
### Time Complexity: O(N), Since each element is traversed at max 2 times.
### Space Complexity: O(N), char array which converts to output string.