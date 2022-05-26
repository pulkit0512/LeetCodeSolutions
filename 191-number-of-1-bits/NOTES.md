* **Approach:** Instead of checking every bit of the number, we repeatedly flip the least-significant 1-bit of the number to 0, and add 1 to the sum. As soon as the number becomes 0, we know that it does not have any more 1-bits, and we return the sum.
​
* The key idea here is to realize that for any number n, doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0.
​
* n = 3 = 011
* n-1 = 2 = 010
* anding these two will result in flipping the least significant 1 bit of 3 to zero and sum becomes 1.
* n = 2 = 010
* n = 1 = 001
* anding these two will result in flipping the least significant 1 bit of 2 to zero ans sum becomes 2 and n becomes 0. So ans is 2.
​
* **Complexity Analysis**
​
* **The run time depends on the number of 1-bits in n. In the worst case, all bits in n are 1-bits. In case of a 32-bit integer, the run time is O(1).
* The space complexity is O(1), since no additional space is allocated.**