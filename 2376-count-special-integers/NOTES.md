## Approach:
```
Step 1:-
Firstly find number of ways to get special integers with total number of digits less than that in n.
​
Suppose we want to make number of length x. So the number of ways will be 9 * (9 * 8 * ... * (9-x+1)). First 9 will be because we can have 9 digits as the first number i.e. except 0 and remaining are the ways for putting the remaing numbers in different orders.
​
Step 2:-
Secondly number of ways to get special integers with total number of digits equal to that in n.
​
For each position s[i] we calculate the digits less than s[i] which we can keep at this position and is not taken previously and multiplying this count with the ways to fill remaining digits which is similar to what we did above.
​
Example of step 2:-
​
Lets assume n=3635
​
i=0,s[i]=3
So we can place 1, 2 at the first position and remaining three positions can be filled with (9*8*7) ways as 9 different digits will be remaining after filling the first place (All these numbers will be smaller than n as we have 1 or 2 at the first place). So total ways is 2*(9*8*7). Now fix s[i]=3 and move forward.
​
i=1, s[i]=6
So we can place 0,1,2,4,5 at this position (not 3 as 3 is fixed at first position) and remaining two positions can be filled with (8*7) ways as 8 different digits will be remaining after filling this place (All these numbers will also be smaller than n and the reason you know). So total ways is5*(8*7). Now fix s[i]=6 and move forward.
​
i=2, s[i]=3
So we can place 0,1,2 at this position and last position can be filled with 7) ways as 7 different digits will be remaining after filling this place. So total ways is 3*(7).
​
Now again we fix s[i]=3 but we cannot move forward as 3 is already taken so we will simply return the answer.
```
​
### Time Complexity: O(1), since length can be max of 10.
### Space Complexity: O(1)