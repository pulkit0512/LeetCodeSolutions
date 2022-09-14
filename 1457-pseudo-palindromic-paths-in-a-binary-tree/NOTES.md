## Approach: PreOrder
* To keep track of frequency of each digit, using bitwise xor. Since we only need to see if a frequency of digit is odd or even. If a particular bit is set then it has odd frequency else even. Since a^a=0 and a^a^a=a
* Using preorder traversal, first xor the bits tracker with current node value.
* Check if current node is leaf then get the number of set bits if it is less then equal to 1 then our path is pseudo palindrome.
* If node is not leaf, make recursive left and right call.
* Once done, reset the bit using current node value.
​
### Time Complexity: O(N), N=Number of Nodes
### Space Complexity: O(H), H=height of tree