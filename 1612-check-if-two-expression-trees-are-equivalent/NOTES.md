## Approach: Used Map
In this Approach, I have used map of Character vs Integer to keep the number of time a operand is repeating while doing a post order traversal. I have cattered the case where '-' operation is also allowed. So using first node I am creating a map, current node is positive operation call the left and right childs with same sign as parent call. But when current node is a negative opeation call the left child with same sign as of parent call but for righ child call inverse the sign.
While storing operands in map with sign as -1 then convert the operand to uppercase the store since input can only have lower case characters we can uppercase characters to distinguish positive and negative characters.
Now with the 2nd root I am checking the weather trees are equivalent or not doing a post order traversal similar to above one. If current node not present return false else update the count of operand. For negative sign convert operand to upper case before fetching from map.
​
### Time Complexity: O(N)
### Space Complexity: O(N);