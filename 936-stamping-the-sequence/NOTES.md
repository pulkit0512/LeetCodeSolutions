## Approach1:
* We need to convert an empty string to target string using the stamp given.
* Instead of converting empty string to target we move backward from target string to empty string.
* For this for any index as start index check if this substring is exact match of stamp then change all the characters of target to '?'. Store the starting index in stack since we can make operating from this index. Now these characters will behave like wildcard and any char can come on these places.
* Repeat this step untill there are occurences of stamp in the target. If we don't get any substring same as stamp and some characters are still not converted to '?' then return empty array it's not possible to convert the target to empty string.
* Once done, from stack push the order in the answer array and return.
​
### Time Complexity: O(NumberOfSteps x (N-M) x M), N = length of target, M = length of stamp.
### Space Complexity: O(N + NumberOfSteps)
​
## Approach2: Using Stack, Queues and set
* In this approach as well we move in reverse direction from target to empty string.
* Each index will become starting of the stamp and for that length we will check which characters are at same position and which are on different position.
* For each window we maintain two sets one to store all chars index which are at same position (match set) and other to store all chars index which are at different position (todo set).
* If for any window we don't have any chars in todo set then this start index will be one operation add it in result stack.
* Also add all the match indexes for this index to the queue for future processing and mark these indexes as done so that it won't be added again.
* Once done, iterate over the queue. For each polled index we will consider it as end index of the window.
* For each character, let's look at all the windows that intersect it, and update their todo lists. If any todo lists become empty in this manner (window.todo is empty), then we enqueue the characters in window.matchSet that we haven't processed yet.
​
### Time Complexity: O(N(N-M)), N = length of target and M = length of stamp
### Space Complexity: O(N(N-M))