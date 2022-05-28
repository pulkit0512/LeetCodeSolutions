## Approach: Using Stack
* In this question, I have used stack of pair to store the price and day of the price. When a call to function "next" is made I am trying to find the next greater element to left from the stack. For start at initialization I have inserted a dummy pair in stack to avoid empty checks for stack.
* If in a function call, while price is greater then or equal to what we have at peek of stack we pop pairs out. Once done ans is what is day right now - day at peek of stack.
* Push new pair to stack.
* return ans.
​
### Complexity Analysis
* **Time Complexity: O(N), each price is traversed at max 2 times**
* **Space Complexity: O(N), in case of reverse order price calls in which ans is always one.**