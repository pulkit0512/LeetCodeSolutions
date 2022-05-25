* **Approach1: Using Stack**
* In this question, I am using a stack to store integer values of the expression and char to store the last operation we have seen and initialized it with '+'. If last operation is '+' pushing interger value in stack, if '-' then pushing negative of the integer in stack. If last operation is '*' or '/' poping the stack top and performed the operation with the current val and pushed back it in stack.
* Once done with the string iteration untill stack is not empty added all values present in stack to result.
​
* **Complexity Analysis**
​
* **Time Complexity: O(n)**, where nn is the length of the string s. We iterate over the string s at most twice.
​
* **Space Complexity: O(n)**, where n is the length of the string s.
​
​
* **Approach2: Using constant space**
* In this approach, I have used three variable current val, last val, result till now. And also used one char to keep track of last operation initialized with '+'.
* If character is digit prepare the integer val from the string. If not if last operation is '+' or '-' then add last value to result. And update last with current value based on the operation.
* If last operation is '*' or '/' update last with operation perform on last and current.
* At end update the last operation with current operation and current with 0.
* In the end add the last to the result.
​
* **Complexity Analysis**
​
* **Time Complexity: O(n)**, where n is the length of the string s.
​
* **Space Complexity: O(1)**, as we use constant extra space to store lastNumber, result and so on.