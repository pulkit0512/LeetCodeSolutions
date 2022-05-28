## Approach: Using O(1) space
In this I have used a variable min which will store minimum of all the elements present in stack till now and we have Stack of Long.
### push:
* If stack is empty push the val and set min to val. Else if val is greater or equal to min the push val. Else we will be using a dummy variable operation to push new val in stack and update min with current val.
* val<min
* 2*val<2*min
* 2*val - min<min
* We will push (2*val-min) in stack and will update min to val.
### pop:
* If top of stack is greater or equal to min pop the element out. Else pop the element but we need to get the old min back.
* Element Pushed: 2*val-min
* newMin = val
* after pop
* newMin = 2*newMin - element to be popped
* newMin = 2*newMin - (2*val - oldMin)
* newMin = 2*val - (2*val - oldMin)
* newMin = oldMin
* We got the old min back.
### top:
If peek is greater or equal to min return peek else return min.
### getMin:
return min
​
### Complexity Analysis
* **Time Complexity: O(1) for all operations**
* **Space Complexity: O(N)**
​
## Approach2: Using Stack of pairs
In this approach we can have a stack storing pair which is the element and the minimum so far. So when we push we push element and minimum so far. While poping pop without any checks. While return top value of stack and for min also return min stored in peek of stack.
​
### Complexity Analysis
* **Time Complexity: O(1) for all operations**
* **Space Complexity: O(N)**
​
## Approach3: Using 2 Stacks
Similar to above approach instead of storing pairs in one stack we can store the values individually in two stacks.
​
### Complexity Analysis
* **Time Complexity: O(1) for all operations**
* **Space Complexity: O(1)**