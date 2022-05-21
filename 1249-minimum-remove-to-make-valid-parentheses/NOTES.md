* **Approach:** This Question is variation of stack or balancing parenthesis. I have used two varaibles balance and openSeen in the string. Balance will maintain number of brackets yet to be balanced out and openSeen keeps the track of number of open brackets we have seen till now.
* We will increment balance whenever we encounter open bracket and will decrement if encounter close bracket and balance is greater than 0 else reject this close bracket.
* Append the accepted character to string builder.
* After this iteration, if balance is 0 return sb as answer.
* Else we need to remove some open brackets which is equal to open = openSeen-balance
* this will be the number of open brackets in the final answer.
* Append all the chars untill we can open brackets after that reject all open brackets.
* Return the answer after this iteration.
​
* **Complexity Analysis**
​
* **Time complexity : O(n), where n is the length of the input string.**
​
* We have 2 loops that are looping through up to nn characters, doing an O(1) operation on each. We also have some O(n) library function calls outside of the loops.
​
* **Space complexity : O(n), where n is the length of the input string.**