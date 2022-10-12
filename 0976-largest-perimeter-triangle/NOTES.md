## Approach: Greedy
* Sort the array.
* For three sides a,b,c such that a<=b<=c, then sum of two smaller sides should be greater then the third side.
* If found a+b>c return parameter. Else return 0.
​
### Time Complexity: O(NLogN)
### Space Complexity: O(LogN) for sorting.