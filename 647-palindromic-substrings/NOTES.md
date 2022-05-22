* **Approach1:** In this question I have used 2D DP to keep track of all the palindromic substrings. Whenever we found a palindromic substring increment the answer by 1. All substrings of length 1 will be a palindromic substring. All substrings of length 2 will be palindromic if both characters are same. For more than 2 length subtring will be palindromic if extreme chars are equal and remaining part of that substring is already a palindromic substring.
​
* **Time Complexity: O(NxN)**
* **Space Complexity: O(NxN)**
​
* **Approach2: Expanding around the centers.** In this approach, We will expand along the centres and will try to find odd and even palindromic substrings. At index i as ceter, for even substrings we will start with i-1 & i index and for odd substrings we will start with i-1 & i+1 index .For each equal char at these index we will increment the answer by 1 since it will be a palindrome. If it's not equal break out from the search.
​
* **Time Complexity: O(NxN)**
* **Space Complexity: O(1)**
​
* **Approach3:**
* **Can you reduce the space consumption of this approach to linear extra space (i.e. O(N))?**
​
* Yes, it's possible! Notice that the states of a subsbtring of length nn actually rely only on states for substrings of length n-2. Thus, we can choose to store only the states for substrings of length n-1 and n-2 for an iteration of susbtrings of length n, which takes only O(N) extra space. All states older than those can be discarded in that iteration.