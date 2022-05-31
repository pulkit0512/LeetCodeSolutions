## Approach1: Using 2 Stacks
In this approach, I have used two stacks and while pushing a element to stack we first empty the main stack and push into temp stack. Then push the new val to main stack then again add values back to main stack from temp stack. So oldest element always remain in top. To pop() just remove the top element. For peek() return value of top element. For empty check size of queue.
​
### Complexity Analysis:
#### Push: O(N), becuase for each push we revert the stack
#### Pop: O(1), removing and returning top element
#### Top: O(1), returning top element
#### Empty: O(1), checking size of stack.
​
## Approach2: Using 2 Stacks push O(1) and pop amortized O(1)
In this approach, I have used to stacks and a variable front which will keep track of front of queue. For Push if main stack is empty update the front and push the val to stack. This is O(1). For pop if temp stack is empty then we push all the elements from main stack to temp stack i.e. reversing the stack and now these N elements will work as queue. This will be O(N) but this will be per n push calls before the pop for all other pop calls it will be O(1) operation from temp to stack. For peek() is temp stack is not empty return top of temp stack else return front val. For empty() check whether both stacks are empty or not.
​
### Complexity Analysis:
#### Push: O(1), becuase for each push we update front if main stack is empty, push the val to main stack.
#### Pop: Amortized O(1), if temp stack is empty that call will be O(N) since we push all elements of main stack to temp stack and now it will act as queue and for other calls time will be O(1)
#### Top: O(1), returning top element of temp stack if not empty else return front.
#### Empty: O(1), checking size of both stacks.