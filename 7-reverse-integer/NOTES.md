## Approach:
* Store the original sign of x.
* Reverse the x. Since we can't use long to check for overflow so if (x>max/10 || (x==max/10 && x%10>7)) then it's a overflow.
* Else reverse x and return with sign.
​
### Time Complexity: O(LogN)
### Space Complexity: O(1)