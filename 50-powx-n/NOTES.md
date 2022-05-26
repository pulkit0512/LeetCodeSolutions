## Approach: Fast exponentiation
* In this question, I have used fast exponentiation to calculate power. Stored the power to long to cater the integer min value case. If power is negative, calculate power as positive only and in end return 1/power. Else return power.
​
* FastExponention:
1. Intialize result with 1.0.
2. If power is odd multiply result with base and reduce power by one.
3. Else square the base and half the power.
4. return result
​
### Complexity Analysis
​
* **Time complexity : O(logn).** For each bit of n 's binary representation, we will at most multiply once. So the total time complexity is O(logn).
​
* **Space complexity : O(1).** We only need two variables for the current product and the final result of x.