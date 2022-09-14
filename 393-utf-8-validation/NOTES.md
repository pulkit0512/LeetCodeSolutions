## Approach:
* For each int, create a binary array of size 8.
* If we have a start of a unicode, check the type of unicode else check if it satisfies condition of subsequent UTF-8 encodings. If not return false. Else decrement the count of subsequent encodings.
​
### Time Complexity: O(N)
### Space Complexity: O(1)