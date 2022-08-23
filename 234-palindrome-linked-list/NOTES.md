## Approach:
* Get middle (endOfFirstHalf) of linkedList using slow fast pointers.
* Once done reverse the secondHalf(middle.next).
* Now compare both the halves. If any node not equal then not a palindrome return false else return true.
​
### Time Complexity: O(N)
### Space Complexity: O(1)