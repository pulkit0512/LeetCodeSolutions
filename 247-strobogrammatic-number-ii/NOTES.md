## Approach:
* Recursion, Base case will be n=1 or n=2
* From n=3, if n is odd we depend on recursion for (n-2) and base case of n=1,
* if n is evern we depend on recursion for (n-2) and base case of n=2
* from these two we get two sets of list. Merge the words from both list to get the new list.
​
​
### Time Complexity: O(N x 5^(N/2)), since for each merging of list we add 5 pairs of substrings to the other. And N/2 since we take a jump of 2 in one recursion call.
​
### Space Complexity: O(N x 5^(N/2))