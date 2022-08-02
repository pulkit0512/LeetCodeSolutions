## Approach1: Use Internal Buffer of 4 Characters
* This is an interactive problem, read4 take an char array of size 4 and writes atmost next 4 character in it from the file.
* We keep on reading from the file untill we read the complete file or we fetched required n characters from the file.
* buf array which read4 takes as input writes the output from read4 to the global buffer array. Return the count of characters we read from the file.
​
### Time Complexity: O(N/4)
### Space Complexity: O(1)