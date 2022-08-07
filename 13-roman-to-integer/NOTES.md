## Approach:
* Roman to Integer conversion. For each char in roman add it's numeric value to answer.
* We need to follow roman number rules. If current char is X or V and previous char is I then we need to subtract 2 from answer. This is done because for IX we first add 1 to ans and then 10 so total became 11 instead it's 9. We have 2 extra one from I and one from X. So substract 2 from answer.
* In similar case if current char is C or L and previous char is X then subtract 20 from answer.
* And if current char is M or D and previous char is C then subtract 200 from answer.
​
### Time Complexity: O(Len)
### Space Complexity: O(1)