* **For both approaches s="("+s+")";
* Approach1: Using 2 stacks.**
* In this I have used two stacks, one to store integer values and other to store characters (operators and brackets). In case peek of stack storing characters is '-' then I am storing negative value in stack. Else positive value in integer stack. When I am at digits I am preparing the integer value and if after that I get a '+' or '-' I am storing the integer in stack as mentioned above and at same time storing the operater as well in operator stack. If I reach to closing bracket. Then if peek operation stack is '-' then reverse the sign of integer I got and then start poping out and adding values from integer stack to the current value and also pop out the operators from other stack untill peek is not equal to '('. Pop the peek char.
* Follow this untill we reach end. At end we will have answer in the val we got when we reach last closing bracket.
​
* **Time Complexity: O(N)**, N=length of string and we traverse each char once.
* **Space Complexity: O(2N) = O(N)** two stacks for integer and operator.
​
* Approach2: Using one stack.
* In this approach I am using a integer stack that will store the result of some calculations as well as sign for the next calculation to come. I am also using result and sign variable to result so far a sub expression and sign of operand which is about to come.
* If we reach to '(' then push the result and sign to stack to store the result uptill now and over sign of the coming subexpression. Set result to 0 for the next sub expression.
* In case of digits prepare the current char.
* In case of '+' or '-' add the current * sign of the operand to result and update sign on the basis of operation. and set current to 0.
* In case of ')' add current * sign of current to result. Update the result with it's sign after poping the sign out and multiply with result. Add result of left part to right part. set current to 0.
* At the end result will have answer.
​
* **Complexity Analysis**
​
* **Time Complexity: O(N)**, where N is the length of the string.
​
* **Space Complexity: O(N)**, where N is the length of the string.