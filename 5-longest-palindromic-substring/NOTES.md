## Approach1: DP Gap Strategy
* Use gap strategy, for 0 gap all substrings of length 1 are palindrome.
* for 1 gap if both chars are equal then they are palindrome.
* for rest if extreme chars are equal and using gap startegy diagonally down is also palindrome then current substring is also palindrome.
* return largest palindrome.
​
### Time Complexity: O(Len x Len)
### Space Complexity: O(Len x Len)
​
## Approach2: DP
* In this for given index as middle character tried to find largest even substring and odd substring.
* return largest palindromic substring.
​
### Time Complexity: O(Len x Len)
### Space Complexity: O(1)