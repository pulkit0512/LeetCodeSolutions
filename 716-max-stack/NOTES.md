## Approach1: Using 2 Stacks
In this approach, I am using two stack one to store value which comes to push method and other one is to store the max till now in the stack.
#### push: In normal stack push the element when it comes, In the max stack if it is empty or peek is less then new value push new value in max stack else push the peek of max stack again.
Max Stack: [2, 1, 5, 3, 9], we'll remember [2, 2, 5, 5, 9]
​
#### top: return top of normal stack
​
#### pop: pop the top of max stack and pop out from normal stack as well return this value.
​
#### peekMax: return top of max stack
​
#### popMax: For this we first get the peek max store it in a variable and now create a temp stack and untill peek of normal stack is not same as peek max, call pop() and push the values in temp stack. pop() will pop out the values from both normal and max stack. Now remove the peek of normal stack which is max peek. Now untill temp stack is not empty call push with elements poped out from temp. Stack it will refill normal and max stack. Return the value fetched for peek max in begining.
​
### Complexity Analysis
* **Time Complexity: O(N) for the popMax operation, and O(1) for the other operations, where N is the number of operations performed.**
* **Space Complexity: O(N)**, the maximum size of the stack.
​
​
## Approach 2: Using DLL and TreeMap
In this approach created DLL class which is having a dummy head and tail.
**Add** function to add node before tail.
**Peek** function to return value to tail.prev node
**Pop** function to delete and return value of tail.prev
**Delete** funtion to delete a node from DLL.
**TreeMap is also used to have keys in sorted order.**
​
#### Push: when push is called add new node to DLL and for int val add node created in the treeMap under list for the same val.
​
#### Pop: Get the value of last node and remove that node from DLL. Now remove the node from treeMap from given val from the end. Return value of just removed.
​
#### Top: Return last node value from DLL.
​
#### PeekMax: Return treeMap lastKey.
​
#### PopMax: Store the last key of map in variable. Get last node of this val from map. Delete it from DLL and map. If map.get(val).isEmpty remove this entry from map. Return the stored value.
​
​
### Complexity Analysis
​
* **Time Complexity: O(logN) for all operations except peek which is O(1), where N is the number of operations performed. Most operations involving TreeMap are O(logN).**
* **Space Complexity: O(N), the size of the data structures used.**