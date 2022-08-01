## Approach1: Using Two pointers
* Keep track of value to be used for next insertion.
* If current char is "I", perm[i] will be value and increment the value.
* If current char is "D", keep increasing the value untill we found "I". Once found from the index where D started to this index, perm[i] = value and decrease value for next indexes.
* Once done value will be the max value used till now + 1.
* For last index if last character in string is D then value will be previous value - 1. Else value will be max value used till now + 1.
​
### Time Complexity: O(2 x Len)
### Space Complexity: O(1)
​
## Approach2: Using Stack
* If current char is D, insert the position of current char in stack.
* If current char is I, res[j] = current position and while stack not empty, next values we will get from stack.
* Insert len+1 in stack, and then untill stack not empty next values will be popped from stack.
​
### Time Complexity: O(2 x Len)
### Space Complexity: O(Len)