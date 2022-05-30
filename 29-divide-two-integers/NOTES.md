## Approach1: When System allows Long
* In this approach, I have checked if only one of the given value is negative then set sign as -1. Then converted both the inputs to positive integer.
* Initialized quetiont and sum used till now as 0.
* for i=31 to 0, if Sum used till now + (divisor<<i) <= dividend then added this divisor<<i to sum used till now and updated quetiont by add (1<<i) these number of times that divisor is repeated for current step.
* if sign is positive and quetiont is greater then int max val return max value
* if sign negative return -quetiont else return quetiont.
​
* **Time Complexity: O(1)**
* **Space Complexity: O(1)**
​
## Approach2: When System doesn't allows Long
* In this approach, first handled the special case of overflow if divisor is 1 or -1 and divided is Min Value return values accordingly.
* Then converted both values to negative and also maintained count of negative in the original input.
* Found the maxBit of divisor while it is greater then equal to half of int min val and greater then half of dividend.
* then iterated from maxBit to 0 if divisor>= dividend we can remove divisor from dividend and subtract (1<<i) from quetiont so that we can have number of times divisor is used for current step.
* Update the divisor by doing right shift since we need half of divisor now, we need to add 1 to divisor to handle right shift of odd negative numbers. Since right shift of even negative number gives correct result but for odd it gives value+1, since it work's on two's complement which filps the bits and add 1. So to nullify addtion of 1 we add 1 now to negative number.
* -60 >> 1 = -30
* -61 >> 1 = -31 --> gives +1
* therefor add 1
* (-60+1) >> 1 = -59 >> 1 = -30 since it will give +1 for odd
* (-61+1) >> 1 = -60 >> 1 = -30
* both even odd are correct.
* if only 1 element was negative in original input return quetiont else return -quetiont.
​
### Complexity Analysis
* Let n be the absolute value of dividend.
​
* **Time Complexity : O(logn).**
* As we loop over the bits of our dividend, performing an O(1) operation each time, the time complexity is just the number of bits of the dividend: O(logn).
​
* **Space Complexity : O(1).**
* We only use a fixed number of int variables, so the space complexity is O(1).