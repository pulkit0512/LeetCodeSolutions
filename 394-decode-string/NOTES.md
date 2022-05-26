* **Approach:** In this question, I have used a single stack of objects to store the interger values as well as string formed and the open bracket character. So if we encounter a digit we will append it into the value and if before getting a digit we have some string. So we push that string to stack and setting the string to be pushed next to empty. If we encounter an open bracket push the val we have for this bracket, push open bracket and set val to 0. If we encounter a character append it to string to be push next.
* When we get a closing bracket, if st.peek() is not equal to open bracket then append string to be push next to top of stack string. pop out the top as it will have open bracket.
* Fetch the number of times this string will be repeated and prepare the repeated string.
* While top of stack is not open char append the prepared string to popped out top of stack.
* Push this processed string back to stack.
​
* Return the top of stack as answer.
​
​
* **Complexity Analysis**
* Assume, n is the length of the string s.
​
* **Time Complexity: O(maxK⋅n)**, where maxK is the maximum value of k and n is the length of a given string s. We traverse a string of size n and iterate k times to decode each pattern of form k[string]. This gives us worst case time complexity as O(maxK⋅n).
*
* **Space Complexity: O(n)**