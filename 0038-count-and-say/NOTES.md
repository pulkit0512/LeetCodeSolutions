## Approach:
* Start with a base case of "1" for i = 1.
* Then for i=2 to n, take the previous String and iterate over it.
* During each iteration find different groups of digits in the string and keep count of each group using a variable.
* Once a new group starts, append information about previous group i.e. its digit and count to the current string. And now reset the count.
* After each iteration mark current string as previous string and now start building current string in next iteration from previous string.
​