## Approach: Using Queue & Recursion
* In this approach using recursion in constructor I have flattened the list the store the values in queue. If current val was list then recursively calling the function else storing the integer in queue.
* next(): Poll out the top of queue
* hasNext(): If queue.isEmpty() false else true.
​
### Complexity Analysis
​
* Let N be the total number of integers within the nested list, L be the total number of lists within the nested list, and D be the maximum nesting depth (maximum number of lists inside each other).
​
* **Time complexity:**
​
* We'll analyze each of the methods separately.
​
* **Constructor: O(N+L).**
​
* The constructor is where all the time-consuming work is done.
​
* For each list within the nested list, there will be one call to flattenList(...). The loop within flattenList(...) will then iterate n times, where n is the number of integers within that list. Across all calls to flattenList(...), there will be a total of N loop iterations. Therefore, the time complexity is the number of lists plus the number of integers, giving us O(N + L).
​
* Notice that the maximum depth of the nesting does not impact the time complexity.
​
* **next(): O(1).**
​
* Getting the next element by popping out from queue is O(1) operation.
​
* **hasNext(): O(1).**
​
* Checking whether or not queue is empty is an O(1) operation.
​
* **Space complexity : O(N + D).**
​
* The most obvious auxiliary space is the integers list. The length of this is O(N).
​
* The less obvious auxiliary space is the space used by the flattenList(...) function. Recall that recursive functions need to keep track of where they're up to by putting stack frames on the runtime stack. Therefore, we need to determine what the maximum number of stack frames there could be at a time is. Each time we encounter a nested list, we call flattenList(...) and a stack frame is added. Each time we finish processing a nested list, flattenList(...) returns and a stack frame is removed. Therefore, the maximum number of stack frames on the runtime stack is the maximum nesting depth, D.
​
* Because these two operations happen one-after-the-other, and either could be the largest, we add their time complexities together giving a final result of O(N+D).