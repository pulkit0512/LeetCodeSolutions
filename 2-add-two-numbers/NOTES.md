* **Approach:** In this question, I have iterated over the two list and added the value of nodes currently pointed and also maintaining carray variable to store the curry of the sum and storing the modulo 10 of the sum in the node. Once we come out of the loop iterate over the list in which we have reached the end and perform similar and carry calculations. In last if carry == 1 create one new node with value and attach it to end.
​
* **Time Complexity: O(max(m, n))**
* **Space Complexity: O(1)**