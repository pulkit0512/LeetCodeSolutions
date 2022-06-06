## Approach:
Move Backwards. At each step we either add 1 to target if odd or divide it by 2 if even untill target is greater then startValue and increase ans at each updation of target.
Once target<startValue, we will +1 type moves in target to reach startValue.
​
### Time Complexity: O(Log(Target))
### Space Complexity: O(1).