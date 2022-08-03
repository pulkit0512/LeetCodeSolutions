## Approach:
* Create a map of index vs (src[index], target[index]).
* Start building the answer. Iterate over the input string if map contains the index, check if src[i] is present in the input string in that index or not. If present append target[i] and move src[i] length ahead. Else append the current char to ans.
* Return ans.
​
### Time Complexity: O(Len x Max source length)
### Space Complexity: O(N x (sources.length() + target.length())
​