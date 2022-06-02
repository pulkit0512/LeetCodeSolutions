## Approach: Using two pointers
* In this approach, I have used two pointers inner and outer pointer.
* At each **next** call if outer nested vectors are present and we reach end of current vector then increment outer pointer and reset inner pointer to 0. Return value of vector at indexes outer, inner.
* At each **hasNext** call, similarly like next call keep incrementing outer till outer is less then length of 2D vector and inner is equal to length inner vector. If outer becomes length of 2D vector return false else true.
​
### Complexity Analysis
* **Time complexity.**
* **Constructor: O(1).**
* We're only storing a reference to the input vector—an O(1) operation.
*
* **next() / hasNext(): O(V/N) or O(1).**
* The cost of both these methods depends on how they are called. If we just got a value from next(), then the next call to either method will involve while loop. In this case the time complexity is O(V/N).
* However if we call hasNext(), then all successive calls to hasNext(), or the next call to next(), will be O(1). This is because while loop will only perform an O(1) check and immediately return.
*
* **Space complexity : O(1).**
* We only use a fixed set of O(1) fields (remember vector is a reference, not a copy!). So the space complexity is O(1).