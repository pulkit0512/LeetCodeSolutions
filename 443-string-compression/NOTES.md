## Approach: Using StringBuilder
In this approach traversed the char array if equal prev char increment it's count else append prev char to string builder and if count greater then 1 append count to string builder. At end add the last char and it's count.
Iterate over the StringBuilder and set it's char in the input array and return it's length.
​
### Time Complexity: O(N)
### Space Complexity: O(N), StringBuilder of length N.