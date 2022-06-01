## Approach: Using Constant Space
In this approach, I have used two variables and there respective counters. If current number is equal to any of the potential majority element increment it's counter. If counter of one variable is 0 set current number as next potential majority element and set it's counter to 1. Else decrement the counter of both elements by 1.
In the end we will have two potential candidates of majority elements. Then using a loop check if there frequency is greater then n/3 then add it in answer.
​
### Time Complexity: O(2N) = O(N)
### Space Complexity: O(1)