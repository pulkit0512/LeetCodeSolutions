## Approach:
* Treverse through the list, once reached to left. The store the previous of left and from left to right reverse the list.
* Once done, if not null next of prev stored in above step will be right node.
* Next of original left will original next of right node.
​
### Time Complexity: O(N)
### Space Complexity: O(1)
​