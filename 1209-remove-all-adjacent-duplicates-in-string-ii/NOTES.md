## Approach:
In this approach, used a freqStack to store char and it's adjacent repeat freq. If stack empty or current char not same as peek char push curr char with freq as 1 to freqStack. Else if current char is equal to peek char and freq of peek char is k-1 pop it out from stack. Else if increment frequency of peek char by 1. In the end pop elements out from stack add in string for count times. Reverse string and return answer.
​
### Time Complexity: O(N)
### Space Complexity: O(N)