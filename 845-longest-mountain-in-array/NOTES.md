## Approach1: Using left right array
In this approach, I have used to arrays to store information of increasing arrays length upto index "i" from left and right. Once done with the computation ans is maximum of left[i]+right[i]+1, i.e. maximum increasing subarray from left to index i + maximum increasing subarray from right to index i + index i itself. This computation is done only if we have at least increasing length till now of 1.
​
### Time Complexity: O(N), two pass of length N.
### Space Complexity: O(N), two arrays.
​
​
## Approach2: Using Constant Space
In this approach, from a starting index try to find the length of mountain if exist starting from that point. Update the ans if length is greater then previous ans. And update the starting point to end of current mountain since new mountain will start at end of previous mountain and if starting index >= next index just increment the starting index.
​
### Time Complexity: O(N)
### Space Complexity: O(1)