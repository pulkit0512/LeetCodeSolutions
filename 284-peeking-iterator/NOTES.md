## Approach: Saving Peeked Value
* In this approach, Each time we call .next(...), a value is returned from the Iterator. If we call .next(...) again, a new value will be returned. This means that if we want to use a particular value multiple times, we had better save it.
​
* Our .peek(...) method needs to call .next(...) on the Iterator. But because .next(...) will return a different value next time, we need to store the value we peeked so when .next(...) is called we return the correct value.
​
### Complexity Analysis
* **Time Complexity : All methods: O(1).**
* The operation performed to update our peeked value are all O(1).
* The actual operations from .next() are impossible for us to analyse, as they depend on the given Iterator. By design, they are none of our concern. Our addition to the time is only O(1) though.
​
* **Space Complexity : All methods: O(1).**
* Like with time complexity, the Iterator itself is probably using memory in its own implementation. But again, this is not our concern. Our implementation only uses a few variables, so is O(1).