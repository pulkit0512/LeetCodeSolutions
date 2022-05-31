## Approach1: Using 2 Stacks
In this approach, I have used two stacks and while pushing a element to stack we first empty the main stack and push into temp stack. Then push the new val to main stack then again add values back to main stack from temp stack. So oldest element always remain in top. To pop() just remove the top element. For peek() return value of top element. For empty check size of queue.
​
### Complexity Analysis:
#### Push: O(N), becuase for each push we revert the stack
#### Pop: O(1), removing and returning top element
#### Top: O(1), returning top element
#### Empty: O(1), checking size of stack.