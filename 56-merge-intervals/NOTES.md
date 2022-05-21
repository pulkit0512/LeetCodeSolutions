* Given the array of intervals having start and end. Sort this array on the basis of start. Now iterate over the sorted array and use stack to merge the overlapped interval. If stack is empty push that interval to the stack. In case incoming interval start is less than the stack peek interval end then we overlap the interval. Else push the interval to stack.
​
* Answer is the intervals in the stack in reverse order.
​
**Complexity Analysis**
​
**Time complexity : O(nlogn)**
​
Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the O(nlogn) complexity of sorting.
​
**Space complexity : O(logN) (or O(n))**
​
If we can sort intervals in place, we do not need more than constant additional space, although the sorting itself takes O(logn) space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.