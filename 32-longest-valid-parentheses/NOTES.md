* **Approach: Using Stack**
* In this question, I have used a stack and iterated over the input string. At the starting pushed -1 to indicate closing bracket for safe answer calculation.
* Whenever we get a opening bracket push it's index to stack. If we get a closing bracket and peek of stack is -1 or char at peek of stack is also closing bracket then push the index to stack else settle closing bracket by poping the open bracket calculate the ans as max of ans or i-st.peek().
* return ans.
​
* **Time Complexity: O(N)**
* **Space Complexity: O(N)**
* **N = Length of string**