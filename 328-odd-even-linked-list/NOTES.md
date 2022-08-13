## Approach:
* Using 4 pointers to create seperate odd and even list.
* Using oddHead and oddTail to keep track of odd nodes and using evenHead and evenTail to keep track of even nodes.
* Iterate over the list with a flag which will indicate whether it's a odd move or even.
* If odd move append it to odd list and move the tail to this node. Similarly if even move append it to even list and move tail to this node.
* Once done set oddTail.next to evenHead and evenTail.next to null.
* Return oddHead.
​
### Time Complexity: O(N)
### Space Complexity: O(1)