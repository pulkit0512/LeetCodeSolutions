## Approach: DFS
* Start with each digit from 1 to 9, as the starting digit.
* Then for n-1 digits we make two case last digit + k and last digit - k.
* In case k is 0 both cases are same.
* When we get n digits, add it to the answer list.
​
### Time Complexity: O(2^N), for each digit we have two choices to make.
### Space Complexity: O(2^N), O(N) for stack and 9x2^(N-1) size of list for output.