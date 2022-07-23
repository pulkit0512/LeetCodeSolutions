## Approach:
* Created two maps one for index vs number and other for number vs treeSet of indexes
* When change is called we update the index map as well as remove this index from prev number and add index to provided number.
* When find is called on a number check the number map and return first element from it's tree set if number exist else return -1.
​
### Time Complexity: change == O(LogN), find = O(1)
### Space Complexity: O(Index + Numbers)