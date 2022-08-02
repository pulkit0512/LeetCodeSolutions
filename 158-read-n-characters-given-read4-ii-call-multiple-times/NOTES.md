## Approach: Use Internal buffer
* For each query, we try to fetch upto n characters and in each call we get a buffer of at max 4 characters.
* Maintain a bytesRead in last call and a bufPtr to keep track on used characters for next call to Read.
* When a call to read is made and if we have anything unused character already present in internal buffer we use them first with the help of bufPtr and bytesRead.
* If we reach to n return, else make a call to read4 api and get next 4 characters and reset bufPtr to 0. Fill the remaining characters from the new buffer untill we reach n.
​
### Time Complexity: O(N)
### Space Complexity: O(1)