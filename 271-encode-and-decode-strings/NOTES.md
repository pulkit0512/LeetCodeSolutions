## Approach1: Using 2 Non-Ascii Characters
* In this approach, I have used 2 Non-Ascii Characters 257th and 258th character. If input list is empty I am returning 258th character as encoded string so while decoding if we get this as encoded string return empty list as answer.
* Else I am sepearting each string in input with 257th ascii char and while decoding spliting the input string on the same char untill possible.
* I am using, s.split(ch257, -1) which splits the string in to array maximum possible length i.e. if we have string like " " it will split it into 2 parts of "", "".
* Return decoded array.
​
### Complexity Analysis
* **Time complexity : O(N)** both for encode and decode, where N is a number of strings in the input array.
* **Space complexity : O(1) for encode to keep the output, since the output is one string. O(N) for decode keep the output, since the output is an array of strings.**
​
## Approach2: Using Chunked Transfer encoding.
* In this Approach, I first represented the length of each String into a 4 bytes char array String followed by the string.
* While decoding first read the first 4 characters convert into the length of next String take the substring of that much length and add to result array.
​
**Encode**
1. Iterate over the array of chunks, i.e. strings.
2. For each chunk compute its length, and convert that length into 4-bytes string.
3. Append to encoded string :
4. 4-bytes string with information about chunk size in bytes.
5. Chunk itself.
6. Return encoded string.
​
**Decode**
1. Iterate over the encoded string with a pointer i initiated as 0. While i < n.
2. Read 4 bytes s[i: i + 4]. It's chunk size in bytes. Convert this 4-bytes string to integer length.
3. Move the pointer by 4 bytes i += 4.
4. Append to the decoded array string s[i: i + length].
5. Move the pointer by length bytes i += length.
6. Return decoded array of strings.
​
### Complexity Analysis
* **Time complexity : O(N)** both for encode and decode, where N is a number of strings in the input array.
* **Space complexity : O(1) for encode to keep the output, since the output is one string. O(N) for decode keep the output, since the output is an array of strings.**