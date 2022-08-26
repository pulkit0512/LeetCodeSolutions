## Approach: Count Digits.
* For N, we have array of size 10 to store count of each digit in n.
* Then iterater over 0 to 29 to get powers of 2 and then create a count array for the power.
* If original array and power of 2 array are equal return true.
* If count array of any power of 2 is not equal to count array of n return false.
​
### Time Complexity: O(Log10(N))
### Space Complexity: O(1), since constant array of size 10 is used.