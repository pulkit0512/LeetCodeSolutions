## Approach: ProductFromDigitPairs
* Check if any number is equal to 0 return 0.
* Reverse both numbers.
* Initialize answer string builder with 0 of length N + M.
* For each digit in secondNumber, iterate over the first number.
* We get two digits and curPos in answer will be i + j. Get the carry which stored value at curPos and multiplication result with d1 x d2 + carry.
* Remainder with 10 of this multiplication will be stored at curPos.
* And tens digit of multiplication will be added to the curPos+1 value.
* If the last digit in answer is zero, remove it. Reverse string and return.
​
### Time Complexity: O(M + N)
### Space Complexity: O(M + N)